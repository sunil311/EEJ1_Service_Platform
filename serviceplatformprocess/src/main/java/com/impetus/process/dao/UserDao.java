package com.impetus.process.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.impetus.process.entities.SecUser;
import com.impetus.process.entities.UserRole;

@Repository("userDao")
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
    session.beginTransaction();
    session.saveOrUpdate(secUser);
    session.getTransaction().commit();  
    return secUser;
  }

  public boolean userExists(String email)
  {
    boolean result = false;
    Session session = sessionFactory.getCurrentSession();
    session.beginTransaction();
    Query query = session.createQuery("from SecUser where email =:email");
    query.setParameter("email", email);
    SecUser secUser = (SecUser) query.uniqueResult();
    if (secUser != null)
    {
      result = true;
    }
    session.getTransaction().commit();  
    return result;
  }

  public SecUser findUser(String email, String password)
  {
    Session session = sessionFactory.getCurrentSession();
    session.beginTransaction();
    Query query = session.createQuery("from SecUser where email =:email and password =:password");
    query.setParameter("email", email);
    query.setParameter("password", password);
    SecUser secUser = (SecUser) query.uniqueResult();
    session.getTransaction().commit();  
    return secUser;
  }
  public SecUser findUserByUserId(int userId)
  {
    Session session = sessionFactory.getCurrentSession();
    session.beginTransaction();
    Query query = session.createQuery("from SecUser where userId =:userId");
    query.setParameter("userId", userId);
    SecUser secUser = (SecUser) query.uniqueResult();
    return secUser;
  }
  
  public SecUser findUserByEmailId(String email)
  {
    Session session = sessionFactory.getCurrentSession();
    session.beginTransaction();
    Query query = session.createQuery("from SecUser where email =:email");
    query.setParameter("email", email);
    SecUser secUser = (SecUser) query.uniqueResult();
    return secUser;
  }

  public UserRole getRoleById(int id)
  {
    Session session = sessionFactory.getCurrentSession();
    session.beginTransaction();
    UserRole userRole = session.load(UserRole.class, id);
    session.getTransaction().commit();  
    return userRole;    
  }
  
  public List<String> getAllTenantIds()
  {
	    Session session = sessionFactory.getCurrentSession();
	    session.beginTransaction();
	    Criteria cr = session.createCriteria(SecUser.class)
	    	    .setProjection(Projections.projectionList()
	    	      .add(Projections.property("tenantId"), "tenantId"));
	    List<String> list = cr.list();
	    session.getTransaction().commit();    
    	  return list;
  }
  

  public List<SecUser> getAllInactiveUsers()
  {
    Session session = sessionFactory.getCurrentSession();
    session.beginTransaction();
    Query query = session.createQuery("from SecUser where activated =:activated");
    query.setParameter("activated", false);
    return query.list();
  }
  
  public List<SecUser> updateAggrigator()
  {
    Session session = sessionFactory.getCurrentSession();
    session.beginTransaction();
    Query query = session.createQuery("from SecUser where activated =:activated");
    query.setParameter("activated", false);
    return query.list();
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
