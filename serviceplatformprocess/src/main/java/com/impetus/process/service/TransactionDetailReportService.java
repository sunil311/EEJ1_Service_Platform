package com.impetus.process.service;

import java.util.List;

import com.impetus.process.entities.TransactionDetails;
import com.impetus.process.exception.ServicePlatformException;

/**
 * @author amitb.kumar
 */
public interface TransactionDetailReportService
{

  /**
   * @param providerId
   * @return
   * @throws ServicePlatformDBException
   */
  public List<TransactionDetails> getTransationDetalsById(String providerId)
    throws ServicePlatformException;

  /**
   * @return
   * @throws ServicePlatformDBException
   */
  public List<TransactionDetails> getTransationDetals() throws ServicePlatformException;

}
