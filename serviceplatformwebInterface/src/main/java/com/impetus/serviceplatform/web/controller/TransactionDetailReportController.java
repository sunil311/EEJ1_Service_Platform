/**
 * 
 */
package com.impetus.serviceplatform.web.controller;

import gherkin.deps.com.google.gson.Gson;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.impetus.process.entities.TransactionDetails;
import com.impetus.process.exception.ServicePlatformException;
import com.impetus.process.service.TransactionDetailReportService;

/**
 * @author amitb.kumar
 */
@Controller
public class TransactionDetailReportController
{

  /**
   * 
   */
  private static final String SOMETHING_WENT_WRONG = "Something went wrong!";

  /**
	 * 
	 */
  Logger logger = LoggerFactory.getLogger(getClass());

  /**
	 * 
	 */
  @Autowired
  private TransactionDetailReportService transactionDetailReportService;

  /**
   * @param providerId
   * @return
   * @throws ServicePlatformDBException
   */
  @RequestMapping(value = "/transactionDetails/{providerId}", method = {
      RequestMethod.GET, RequestMethod.POST})
  public @ResponseBody
  String getTransationDetalsById(@PathVariable("providerId")
  String providerId)
  {
    String jsonCartList = "{\"status\":\"" + 200 + "\"}";

    List<TransactionDetails> list = null;
    try
    {
      list = transactionDetailReportService.getTransationDetalsById(providerId);
    }
    catch (ServicePlatformException e)
    {
      logger.error("Exception occured while updating aggregator : ", e);
      return SOMETHING_WENT_WRONG;
    }
    jsonCartList = getJsonFromList(list);

    return jsonCartList;
  }

  /**
   * @return
   * @throws ServicePlatformDBException
   */
  @RequestMapping(value = "/transactionDetails", method = {RequestMethod.GET, RequestMethod.POST})
  public @ResponseBody
  String getTransationDetals()
  {
    String jsonCartList = "{\"status\":\"" + 200 + "\"}";
    List<TransactionDetails> list;
    try
    {
      list = transactionDetailReportService.getTransationDetals();
    }
    catch (ServicePlatformException e)
    {
      logger.error("Exception occured while updating aggregator : ", e);
      return SOMETHING_WENT_WRONG;
    }
    jsonCartList = getJsonFromList(list);
    return "{\"jsonCartList\":\"" + jsonCartList + "\"}";
  }

  /**
   * @param list
   * @return
   */
  private String getJsonFromList(List<TransactionDetails> list)
  {
    String jsonCartList;
    // create a new Gson instance
    Gson gson = new Gson();
    // convert your list to json
    jsonCartList = gson.toJson(list);
    // print your generated json
    System.out.println("jsonCartList: " + jsonCartList);
    return jsonCartList;
  }

}
