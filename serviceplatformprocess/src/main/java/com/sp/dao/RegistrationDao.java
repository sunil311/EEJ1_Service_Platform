package com.sp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.sp.register.Register;
import com.sp.utility.TransSpringHibernateUtilFactory;

@Service
public class RegistrationDao
{
 
  private SessionFactory sessionFactory;

  public void save(Register registerBean) throws Exception
  {
    Session session = TransSpringHibernateUtilFactory.getSession();
    Transaction t = session.beginTransaction();
    session.save(registerBean);
    t.commit();
  }

  public SessionFactory getSessionFactory()
  {
    return sessionFactory;
  }
  //@Autowired
  public void setSessionFactory(SessionFactory sessionFactory)
  {
    this.sessionFactory = sessionFactory;
  }

}
