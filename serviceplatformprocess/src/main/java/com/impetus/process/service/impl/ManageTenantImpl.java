package com.impetus.process.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impetus.process.dao.TenantDatabaseMetadataDao;
import com.impetus.process.dto.InputData;
import com.impetus.process.entities.TenantDatabaseMetadata;
import com.impetus.process.exception.ServicePlatformException;
import com.impetus.process.service.IManageTenant;

/**
 * @author skgupta
 *
 */

@Service("iManageTenant")
public class ManageTenantImpl implements IManageTenant {

	@Autowired
	TenantDatabaseMetadataDao tenantDatabaseMetadataDao;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ManageTenantImpl.class);

	@Override
	public TenantDatabaseMetadata createTenantDatabaseMetadatDetail(
			InputData inputData) throws ServicePlatformException {

		LOGGER.info("Inserting Tenant metadat details in database........");
		TenantDatabaseMetadata tenantDatabaseMetadata = new TenantDatabaseMetadata();
		tenantDatabaseMetadata.setDbHostName(inputData.getDbHostName());
		tenantDatabaseMetadata.setDbHostPort(inputData.getDbPort());
		tenantDatabaseMetadata.setDbName(inputData.getDbName());
		tenantDatabaseMetadata.setDbUserName(inputData.getDbUserName());
		tenantDatabaseMetadata.setDbPassword(inputData.getDbPassword());
		tenantDatabaseMetadata.setTenantId(inputData.getDbName());
		tenantDatabaseMetadataDao.save(tenantDatabaseMetadata);

		return tenantDatabaseMetadata;
	}

	@Override
	public List<TenantDatabaseMetadata> getTenantDatabaseMetadataDetails()
			throws ServicePlatformException {
		List<TenantDatabaseMetadata> tenantDatabaseMetadataList = tenantDatabaseMetadataDao
				.getTenantDatabaseMetadataDetails();
		return tenantDatabaseMetadataList;
	}

}
