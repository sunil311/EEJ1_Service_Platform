package com.impetus.process.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.impetus.process.entities.TenantDatabaseMetadata;
import com.impetus.process.exception.ServicePlatformException;

@Repository("tenantDatabaseMetadataDao")
public class TenantDatabaseMetadataDao {

	@Autowired
	private SessionFactory sessionFactory;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(TenantDatabaseMetadataDao.class);

	/**
	 * This method is used to save tenant database metadata details in the
	 * database
	 * 
	 * @param tenantDatabaseMetadata
	 * @return
	 */
	public TenantDatabaseMetadata save(
			TenantDatabaseMetadata tenantDatabaseMetadata) {

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(tenantDatabaseMetadata);
		session.getTransaction().commit();
		return tenantDatabaseMetadata;
	}

	public List<TenantDatabaseMetadata> getTenantDatabaseMetadataDetails()
			throws ServicePlatformException {
		Session session = sessionFactory.getCurrentSession();

		LOGGER.info("Called DAO");

		SQLQuery query = session
				.createSQLQuery("select * from TENANT_DATABASE_DETAILS");

		LOGGER.debug("list :" + query.list());

		@SuppressWarnings("unchecked")
		List<TenantDatabaseMetadata> list = (List<TenantDatabaseMetadata>) query
				.list();

		return list;
	}
}
