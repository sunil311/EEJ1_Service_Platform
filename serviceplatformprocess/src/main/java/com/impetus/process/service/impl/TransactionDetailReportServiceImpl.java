package com.impetus.process.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impetus.process.dao.TransactionDetailReportDao;
import com.impetus.process.entities.TransactionDetails;
import com.impetus.process.exception.ServicePlatformDBException;
import com.impetus.process.service.TransactionDetailReportService;

/**
 * @author amitb.kumar
 */
@Service("transactionDetailReportService")
public class TransactionDetailReportServiceImpl implements TransactionDetailReportService
{

  /**
	 * 
	 */
  @Autowired
  private TransactionDetailReportDao transactionDetailReportDao;

  /*
   * (non-Javadoc)
   * @see com.impetus.process.service.TransactionDetailReportService#
   * getTransationDetalsById(java.lang.String)
   */
  @Override
  public List<TransactionDetails> getTransationDetalsById(String providerId)
    throws ServicePlatformDBException
  {

    return transactionDetailReportDao.getTransationDetalsById(providerId);
  }

  /*
   * (non-Javadoc)
   * @see
   * com.impetus.process.service.TransactionDetailReportService#getTransationDetals
   * ()
   */
  @Override
  public List<TransactionDetails> getTransationDetals() throws ServicePlatformDBException
  {
    return transactionDetailReportDao.getTransationDetals();
  }
}
