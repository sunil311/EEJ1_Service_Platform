package com.impetus.process.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impetus.process.entities.SecUser;

@Service
public class UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SecUser save(SecUser secUser) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		// do DB interactions
		try {
			session.save(secUser);
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return secUser;
	}

	public boolean userExists(String email) throws Exception {
		boolean result = false;
		Session session = sessionFactory.getCurrentSession();
		// do DB interactions
		try {
			Query query = session
					.createQuery("from SecUser where email =:email");
			query.setParameter("email", email);
			SecUser secUser = (SecUser) query.uniqueResult();
			if (secUser != null) {
				result = true;
			}
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return result;
	}
}
