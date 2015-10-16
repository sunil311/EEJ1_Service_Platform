package com.impetus.process.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impetus.process.entities.SecUser;
import com.impetus.process.entities.UserRole;

@Service
public class UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SecUser save(SecUser secUser) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(secUser);
		return secUser;
	}

	public boolean userExists(String email) {
		boolean result = false;
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from SecUser where email =:email");
		query.setParameter("email", email);
		SecUser secUser = (SecUser) query.uniqueResult();
		if (secUser != null) {
			result = true;
		}
		return result;
	}

	public UserRole getRoleById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.load(UserRole.class, id);
	}

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory
	 *            the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
