package com.sp.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.sp.entities.SecUser;
import com.sp.utility.SessionHandler;

@Service
public class RegistrationDao {
	
	  public SecUser save(SecUser secUser) throws Exception { 
	  //transaction 
	  Session session = SessionHandler.stratTransaction();
	  
	 // do DB interactions 
	  session.save(secUser);
	  // end transaction 
	  SessionHandler.endTransaction(session); 
    return secUser;
	  }
	 
}
