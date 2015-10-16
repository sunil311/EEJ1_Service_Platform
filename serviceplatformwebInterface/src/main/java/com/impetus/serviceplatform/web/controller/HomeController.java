/**
 * 
 */
package com.impetus.serviceplatform.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author kuldeep.singh
 * 
 */
@Controller
public class HomeController {
	@RequestMapping(value = { "", "/home" }, method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String goToHome(ModelMap model) {
		return "home";
	}

}
