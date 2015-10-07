package com.sp.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.sp.entities.UserInfo;
import com.sp.utility.SessionHandler;

@Service
public class RegistrationDao
{
  public void save(UserInfo registerBean) throws Exception
  {
    // Start transaction
    Session session = SessionHandler.stratTransaction();
    
    // do DB interactions
    session.save(registerBean);
    
    // end transaction
    SessionHandler.endTransaction(session);
  }
}
