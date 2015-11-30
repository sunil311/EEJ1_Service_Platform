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

@Configuration
@PropertySource("classpath:package.properties")
@Service("loginProcess")
public class LoginProcess
{
  @Autowired
  Environment env;

  @Autowired
  private UserDao userDao;
  
  String status = "";

  Logger logger = LoggerFactory.getLogger(getClass());

  public String loginUser(LoginData loginData) throws SQLException
  {

	if (!validate(loginData)) {
			return status;
	}
	  
    String result = env.getProperty("process.result.success");
    logger.info("Cheking user........");
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
      logger.info("Login user........USER DO NOT EXISTS");
      result = env.getProperty("process.login.user.not.exist");
    }
    return result;
  }

  private void updateUserSessionData()
  {
    // TODO Auto-generated method stub
  }
  
  private boolean validate(LoginData loginData) {

		if (loginData.getEmail() != null
				&& loginData.getPassword() != null
				&& !(loginData.getEmail().length() >= 6 && loginData.getEmail()
						.length() <= 12)
				&& !(loginData.getPassword().length() >= 6 && loginData
						.getPassword().length() <= 12)) {
			status = "Email and Password should be between 6 and 12.";

		}

		return true;

	}
}
