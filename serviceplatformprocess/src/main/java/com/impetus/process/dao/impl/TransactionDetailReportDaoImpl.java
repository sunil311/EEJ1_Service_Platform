package com.impetus.process.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.impetus.process.dao.TransactionDetailReportDao;
import com.impetus.process.entities.TransactionDetails;
import com.impetus.process.exception.ServicePlatformDBException;

/**
 * @author amitb.kumar
 */
@Repository("transactionDetailReportDao")
public class TransactionDetailReportDaoImpl implements TransactionDetailReportDao
{

  /**
	 * 
	 */
  @Autowired
  private SessionFactory sessionFactory;
  /**
	 * 
	 */
  private static final Logger LOGGER = LoggerFactory
    .getLogger(TransactionDetailReportDaoImpl.class);

  /*
   * (non-Javadoc)
   * @see
   * com.impetus.process.dao.TransactionDetailReportDao#getTransationDetalsById
   * (java.lang.String)
   */
  @Override
  public List<TransactionDetails> getTransationDetalsById(String providerId)
    throws ServicePlatformDBException
  {
    Session session = sessionFactory.getCurrentSession();
    SQLQuery query = session.createSQLQuery("select * from TRANSACTION_DETAILS where provider_Id="
      + providerId);
    @SuppressWarnings("unchecked")
    List<TransactionDetails> list = (List<TransactionDetails>) query.list();

    return list;
  }

  /*
   * (non-Javadoc)
   * @see
   * com.impetus.process.dao.TransactionDetailReportDao#getTransationDetals()
   */
  @Override
  public List<TransactionDetails> getTransationDetals() throws ServicePlatformDBException
  {
    Session session = sessionFactory.getCurrentSession();
    LOGGER.info("Called DAO");
    SQLQuery query = session.createSQLQuery("select * from TRANSACTION_DETAILS");

    LOGGER.debug("list :" + query.list());

    @SuppressWarnings("unchecked")
    List<TransactionDetails> list = (List<TransactionDetails>) query.list();

    return list;
  }

  /**
   * @return the sessionFactory
   */
  /**
   * @return
   */
  public SessionFactory getSessionFactory()
  {
    return sessionFactory;
  }

  /**
   * @param sessionFactory the sessionFactory to set
   */
  /**
   * @param sessionFactory
   */
  public void setSessionFactory(SessionFactory sessionFactory)
  {
    this.sessionFactory = sessionFactory;
  }

}
