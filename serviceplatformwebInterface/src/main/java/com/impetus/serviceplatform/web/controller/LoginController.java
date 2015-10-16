/**
 * 
 */
package com.impetus.serviceplatform.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.impetus.process.dto.LoginData;

@Controller
public class LoginController {
	Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String postService() {
		return "signup";
	}

	@RequestMapping(value = { "/customLoginPage" }, method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String renderLoginForm(ModelMap model) {
		return "customLoginPage";
	}

	@RequestMapping(value = "/loginSave", method = RequestMethod.POST)
	public String saveLogin(@RequestBody LoginData loginData) {
		logger.info(loginData.getEmail());
		logger.info(loginData.getPassword());
		return "views/loginPage";
	}
}
