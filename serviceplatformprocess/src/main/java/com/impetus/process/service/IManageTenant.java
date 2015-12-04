package com.impetus.process.service;

import java.util.List;

import com.impetus.process.dto.InputData;
import com.impetus.process.entities.TenantDatabaseMetadata;
import com.impetus.process.exception.ServicePlatformException;

/**
 * @author skgupta
 *
 */
public interface IManageTenant {

	/**
	 * The api create Tenant database meta-data details in database
	 * 
	 * @param inputData
	 * @return
	 * @throws ServicePlatformException
	 */
	public TenantDatabaseMetadata createTenantDatabaseMetadatDetail(
			InputData inputData) throws ServicePlatformException;

	/**
	 * This api provide list of all tenants database meta-data details
	 * 
	 * @return
	 * @throws ServicePlatformException
	 */
	public List<TenantDatabaseMetadata> getTenantDatabaseMetadataDetails()
			throws ServicePlatformException;
}
