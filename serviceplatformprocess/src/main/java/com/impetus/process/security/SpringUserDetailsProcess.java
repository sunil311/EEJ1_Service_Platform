package com.impetus.process.security;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.impetus.process.entities.SecUser;
import com.impetus.process.entities.UserRole;

public class SpringUserDetailsProcess implements UserDetailsService {
	SessionFactory sessionFactory;
	private static final Logger LOGGER = LoggerFactory
			.getLogger(SpringUserDetailsProcess.class);
	@Override
	public UserDetails loadUserByUsername(String username) {
		SecUser secUser = findUserByUsername(username);
		User user = null;

		if (secUser != null) {
			try {
				List<UserRole> roles = secUser.getRoles();
				String[] rolesArray = new String[roles.size()];
				for (int i = 0; i < rolesArray.length; i++) {
					rolesArray[i] = roles.get(i).getRoleName();
				}
				List<GrantedAuthority> authorities = AuthorityUtils
						.createAuthorityList(rolesArray);
				user = new User(username, secUser.getPassword(), true, true,
						true, true, authorities);
			} catch (Exception e) {
				LOGGER.error("error message : "+e.getMessage());
			}
		}
		return user;
	}

	private SecUser findUserByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(SecUser.class);
		criteria.add(Restrictions.eq("username", username));
		SecUser secUser = (SecUser) criteria.uniqueResult();
		Hibernate.initialize(secUser.getRoles());
		session.getTransaction().commit();
		return secUser;
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
