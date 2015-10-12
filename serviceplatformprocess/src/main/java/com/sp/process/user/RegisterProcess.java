package com.sp.process.user;

import org.springframework.beans.factory.annotation.Autowired;

import com.sp.dao.RegistrationDao;
import com.sp.entities.SecUser;
import com.sp.infos.UserData;

/**
 * 
 * @author rakesh.singhania
 *
 */
public class RegisterProcess
{

  private RegistrationDao registrationDao;

  public void registerUser(UserData userData)
  {
    SecUser secUser =new SecUser();
    secUser.setEmail(userData.getEmail());
    secUser.setFirstName(userData.getFirstName());
    secUser.setLastName(userData.getLastName());
    secUser.setPassword(userData.getPassword());
    secUser.setUsername(userData.getEmail());
    try
    {
      registrationDao.save(secUser);
    }
    catch (Exception e)
    {
      System.out.println("Not success");
      e.printStackTrace();
    }
    
  }
  
  
  public RegistrationDao getRegistrationDao()
  {
    return registrationDao;
  }
  @Autowired
  public void setRegistrationDao(RegistrationDao registrationDao)
  {
    this.registrationDao = registrationDao;
  }

}
