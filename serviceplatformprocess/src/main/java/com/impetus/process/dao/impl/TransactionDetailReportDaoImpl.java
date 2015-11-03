package com.impetus.process.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.impetus.process.dao.TransactionDetailReportDao;
import com.impetus.process.entities.TransactionDetails;
import com.impetus.process.exception.ServicePlatformDBException;

@Repository("transactionDetailReportDao")
public class TransactionDetailReportDaoImpl implements TransactionDetailReportDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<TransactionDetails> getTransationDetalsById(String providerId)
			throws ServicePlatformDBException {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery("select * from TRANSACTION_DETAILS where provider_Id="+providerId);
		@SuppressWarnings("unchecked")
		List<TransactionDetails> list = (List<TransactionDetails>)query.list();
		
		return list;
	}

	@Override
	public List<TransactionDetails> getTransationDetals()
			throws ServicePlatformDBException {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("Called DAO");
		SQLQuery query = session.createSQLQuery("select * from TRANSACTION_DETAILS");
		
		System.out.println(query.list());
		
		@SuppressWarnings("unchecked")
		List<TransactionDetails> list = (List<TransactionDetails>)query.list();
		
		return list;
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
