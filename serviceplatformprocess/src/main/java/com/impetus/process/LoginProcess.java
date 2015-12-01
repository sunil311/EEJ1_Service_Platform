package com.impetus.process;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.impetus.process.dao.UserDao;
import com.impetus.process.dto.LoginData;
import com.impetus.process.entities.SecUser;
import com.impetus.process.entities.UserRole;
import com.impetus.process.enums.Role;

/**
 * @author amitb.kumar
 */
@Configuration
@PropertySource("classpath:package.properties")
@Service("loginProcess")
public class LoginProcess
{
  /**
   * 
   */
  @Autowired
  Environment env;

  /**
   * 
   */
  @Autowired
  private UserDao userDao;

  /**
   * 
   */
  String status = "";

  /**
   * 
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(LoginProcess.class);

  /**
   * @param loginData
   * @return
   * @throws SQLException
   */
  public String loginUser(LoginData loginData) throws SQLException
  {

    if (!validate(loginData))
    {
      return status;
    }

    String result = env.getProperty("process.result.success");
    LOGGER.info("Cheking user........");
    SecUser user = userDao.findUser(loginData.getEmail(), loginData.getPassword());
    boolean hasAdminRole = false;
    if (user != null && user.getRoles() != null)
    {
      for (UserRole role : user.getRoles())
      {
        if (role.getRoleId() == Role.ADMIN.getId())
        {
          hasAdminRole = true;
        }
        break;
      }

    }
    if (user != null && user.getRoles() != null && hasAdminRole)
    {
      updateUserSessionData();
    }
    else
    {
      LOGGER.info("Login user........USER DO NOT EXISTS");
      result = env.getProperty("process.login.user.not.exist");
    }
    return result;
  }

  /**
   * 
   */
  private void updateUserSessionData()
  {
    // TODO Auto-generated method stub
  }

  /**
   * @param loginData
   * @return
   */
  private boolean validate(LoginData loginData)
  {
    boolean passwordStatus = true;
    if (loginData.getEmail() != null && loginData.getPassword() != null
      && !(loginData.getPassword().length() >= 6 && loginData.getPassword().length() <= 12))
    {
      status = "Email and Password should be between 6 and 12.";
      passwordStatus = false;
    }

    return passwordStatus;

  }
}
