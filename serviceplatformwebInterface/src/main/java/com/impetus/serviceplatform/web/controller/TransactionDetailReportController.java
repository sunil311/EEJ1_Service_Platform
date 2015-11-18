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
import com.impetus.process.exception.ServicePlatformDBException;
import com.impetus.process.service.TransactionDetailReportService;

@Controller
public class TransactionDetailReportController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private TransactionDetailReportService transactionDetailReportService;

	@RequestMapping(value = "/transactionDetails/{providerId}", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	String getTransationDetalsById(@PathVariable("providerId") String providerId)
			throws ServicePlatformDBException {
		String jsonCartList = "{\"status\":\"" + 200 + "\"}";

		try {
			List<TransactionDetails> list = transactionDetailReportService
					.getTransationDetalsById(providerId);
			jsonCartList = getJsonFromList(list);

		} catch (Exception e) {
			throw new ServicePlatformDBException("SQL exception occured: "
					+ e.getMessage());
		}
		return jsonCartList;
	}

	@RequestMapping(value = "/transactionDetails", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	String getTransationDetals() throws ServicePlatformDBException {
		String jsonCartList = "{\"status\":\"" + 200 + "\"}";
		try {
			System.out.println("called 1");

			List<TransactionDetails> list = transactionDetailReportService
					.getTransationDetals();
			jsonCartList = getJsonFromList(list);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServicePlatformDBException("SQL exception occured: "
					+ e.getMessage());
		}
		return "{\"jsonCartList\":\"" + jsonCartList + "\"}";
	}

	private String getJsonFromList(List<TransactionDetails> list) {
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
