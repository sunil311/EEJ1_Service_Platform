package com.impetus.process.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impetus.process.entities.SecUser;
import com.impetus.process.entities.UserRole;

@Service
public class UserDao
{

  @Autowired
  private SessionFactory sessionFactory;

  public SecUser save(SecUser secUser)
  {
    // TODO: FOr multi tenancy
    // Session session =
    // sessionFactory.withOptions().tenantIdentifier("rks").openSession();
    Session session = sessionFactory.getCurrentSession();
    session.saveOrUpdate(secUser);

    return secUser;
  }

  public boolean userExists(String email)
  {
    boolean result = false;
    Session session = sessionFactory.getCurrentSession();
    Query query = session.createQuery("from SecUser where email =:email");
    query.setParameter("email", email);
    SecUser secUser = (SecUser) query.uniqueResult();
    if (secUser != null)
    {
      result = true;
    }
    return result;
  }

  public SecUser findUser(String email, String password)
  {
    Session session = sessionFactory.getCurrentSession();
    Query query = session.createQuery("from SecUser where email =:email and password =:password");
    query.setParameter("email", email);
    query.setParameter("password", password);
    SecUser secUser = (SecUser) query.uniqueResult();
    return secUser;
  }

  public UserRole getRoleById(int id)
  {
    Session session = sessionFactory.getCurrentSession();
    return session.load(UserRole.class, id);
  }
  
  public List<String> getAllTenantIds()
  {
    Session session = sessionFactory.getCurrentSession();
    Criteria cr = session.createCriteria(SecUser.class)
    	    .setProjection(Projections.projectionList()
    	      .add(Projections.property("tenantId"), "tenantId"));
    	  return cr.list();
  }

  /**
   * @return the sessionFactory
   */
  public SessionFactory getSessionFactory()
  {
    return sessionFactory;
  }

  /**
   * @param sessionFactory the sessionFactory to set
   */
  public void setSessionFactory(SessionFactory sessionFactory)
  {
    this.sessionFactory = sessionFactory;
  }
}
