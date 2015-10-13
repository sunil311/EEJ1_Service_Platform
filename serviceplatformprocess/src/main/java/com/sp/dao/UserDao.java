package com.sp.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.sp.entities.SecUser;
import com.sp.utility.SessionHandler;

@Service
public class UserDao {

	public SecUser save(SecUser secUser) throws Exception {
		// transaction
		Session session = SessionHandler.stratTransaction();

		// do DB interactions
		try {
			session.save(secUser);
			// end transaction
			SessionHandler.endTransaction(session);
		} catch (Exception e) {
			SessionHandler.revertTransaction(session);
			e.printStackTrace();
			return null;
		}
		return secUser;
	}
	
	public SecUser findUserByEmail(String email) throws Exception {
		SecUser secUser = null;
		// transaction
		Session session = SessionHandler.stratTransaction();

		// do DB interactions
		try {
			Query query = session.createQuery("from SecUser where email =:email");
			secUser = (SecUser) query.uniqueResult();
			// end transaction
			SessionHandler.endTransaction(session);
		} catch (Exception e) {
			SessionHandler.revertTransaction(session);
			e.printStackTrace();
			return null;
		}
		return secUser;
	}
}
