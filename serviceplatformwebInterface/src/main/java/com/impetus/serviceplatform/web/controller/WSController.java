package com.impetus.serviceplatform.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.impetus.process.dto.DBResponse;
import com.impetus.process.dto.InputData;
import com.impetus.process.entities.TenantDatabaseMetadata;
import com.impetus.process.exception.ServicePlatformException;
import com.impetus.process.service.IManageTenant;

@Controller
@RequestMapping(value = "/webservice")
public class WSController {

	@Autowired
	IManageTenant iManageTenant;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(WSController.class);

	/**
	 * Create database at runtime it takes DBname,user name,pass as parameter in
	 * input data
	 * 
	 * @param inputData
	 * @return
	 */
	@RequestMapping(value = "enterTenantDatabaseMetadataDetailsinDB", method = RequestMethod.POST)
	@ResponseBody
	public int createTenantDatabaseMetadatDetail(
			@RequestBody InputData inputData) {

		int result = 0;
		try {
			TenantDatabaseMetadata tenantDatabaseMetadata = iManageTenant
					.createTenantDatabaseMetadatDetail(inputData);
			result = tenantDatabaseMetadata.getDbDetailsId();
		} catch (ServicePlatformException e) {
			LOGGER.error("exception :" + e.getMessage());
		}

		return result;

	}

	/**
	 * This api provide list of all tenant database meta-data details input data
	 * 
	 * @param inputData
	 * @return
	 */
	@RequestMapping(value = "tenantDatabaseMetadataDetails", method = {
			RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public List<DBResponse> getTenantDatabaseMetadatDetails(
			@RequestBody InputData inputData) {

		List<DBResponse> dbResponseList = new ArrayList<DBResponse>();
		List<TenantDatabaseMetadata> tenantDatabaseMetadataList;
		try {
			tenantDatabaseMetadataList = iManageTenant
					.getTenantDatabaseMetadataDetails();
			for (TenantDatabaseMetadata tenantDatabaseMetadata : tenantDatabaseMetadataList) {
				DBResponse dbResponse = new DBResponse();
				dbResponse.setDbName(tenantDatabaseMetadata.getDbName());
				dbResponse
						.setDbPassword(tenantDatabaseMetadata.getDbPassword());
				dbResponse
						.setDbUserName(tenantDatabaseMetadata.getDbUserName());
				dbResponse.setHostName(tenantDatabaseMetadata.getDbHostName());
				dbResponse
						.setPortNumber(tenantDatabaseMetadata.getDbHostPort());
				dbResponseList.add(dbResponse);
			}
		} catch (ServicePlatformException e) {
			LOGGER.error("exception :" + e.getMessage());
		}

		return dbResponseList;

	}
}
