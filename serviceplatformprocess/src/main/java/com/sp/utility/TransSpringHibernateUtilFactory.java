package com.sp.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;

/**
 * A spring factory that is responsible for providing Spring access to the
 * express Hibernate SessionFactory for Transactional Database.
 */
public class TransSpringHibernateUtilFactory
{
  private ApplicationContext ctx;

  protected static SessionFactory buildSessionFactory() throws Exception
  {
    Configuration configuration = new Configuration();
    configuration.configure("hibernate.cfg.xml");
    StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
    SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
    return sessionFactory;
  }
  
  public static Session getSession() throws Exception{
    Session session = null;
    SessionFactory sessionFactory=null;
    try{
       sessionFactory=buildSessionFactory();
        session = sessionFactory.getCurrentSession();
    }catch(HibernateException hex){
        hex.printStackTrace();
    }
    if(session == null){
        session = sessionFactory.openSession();
    }
    return session;
   }

   /**
   * @see org.springframework.beans.factory.FactoryBean#isSingleton()
   */
  public boolean isSingleton()
  {
    return true;
  }

  public ApplicationContext getCtx()
  {
    return ctx;
  }

  public void setCtx(ApplicationContext ctx)
  {
    this.ctx = ctx;
  }
}
