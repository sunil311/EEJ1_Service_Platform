/**
 * 
 */
package com.ee.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sp.infos.LoginData;

@RestController
public class LoginController
{

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public @ResponseBody
	String postService(@RequestBody LoginData loginData) {
	  System.out.println(loginData.getEmail());
	  System.out.println(loginData.getPassword());
    return "loginPage";
  }
  
  @RequestMapping(value = "/loginSave", method = RequestMethod.POST)
  public @ResponseBody
	String saveLogin(@RequestBody LoginData loginData) {
	  System.out.println(loginData.getEmail());
	  System.out.println(loginData.getPassword());
    return "views/loginPage";
  }
}
