package com.sp.process.user;

import org.springframework.beans.factory.annotation.Autowired;

import com.sp.dao.RegistrationDao;
import com.sp.entities.UserInfo;

/**
 * 
 * @author rakesh.singhania
 *
 */
public class RegisterProcess
{

  private RegistrationDao registrationDao;
  
  public String registerUser(UserInfo registerBean) throws Exception{
    registrationDao.save(registerBean);
    return null;
    
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
