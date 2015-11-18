package com.impetus.process.service;

import java.util.List;

import com.impetus.process.entities.TransactionDetails;
import com.impetus.process.exception.ServicePlatformDBException;

public interface TransactionDetailReportService {

	public List<TransactionDetails> getTransationDetalsById(String providerId)
			throws ServicePlatformDBException;

	public List<TransactionDetails> getTransationDetals() throws ServicePlatformDBException;

}
