/**
 * 
 */
package com.impetus.serviceplatform.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.impetus.process.dto.LoginData;

@RestController
public class LoginController {
	Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody
	String postService(@RequestBody LoginData loginData) {
		logger.info(loginData.getEmail());
		logger.info(loginData.getPassword());
		return "loginPage";
	}

	@RequestMapping(value = "/loginSave", method = RequestMethod.POST)
	public @ResponseBody
	String saveLogin(@RequestBody LoginData loginData) {
		logger.info(loginData.getEmail());
		logger.info(loginData.getPassword());
		return "views/loginPage";
	}
}
