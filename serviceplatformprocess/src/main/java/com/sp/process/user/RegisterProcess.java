package com.sp.process.user;

import org.springframework.beans.factory.annotation.Autowired;

import com.sp.dao.RegistrationDao;

/**
 * 
 * @author rakesh.singhania
 *
 */
public class RegisterProcess
{

  private RegistrationDao registrationDao;
  
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
