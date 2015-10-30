/**
 * 
 */
package com.impetus.serviceplatform.web.controller;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.impetus.process.LoginProcess;
import com.impetus.process.dto.LoginData;
import com.impetus.process.exception.ServicePlatformDBException;

@Controller
@SessionAttributes("LoggedInUser")
public class LoginController
{
  Logger logger = LoggerFactory.getLogger(getClass());
  @Autowired
  private LoginProcess loginProcess;
  private String status;

  @RequestMapping(value = "/signup", method = RequestMethod.GET)
  public String postService()
  {
    return "signup";
  }

  @RequestMapping(value = "/RegisterUser/doLogin", method = RequestMethod.POST)
  public @ResponseBody
  String loginUser(@RequestBody
  LoginData loginData) throws ServicePlatformDBException
  {
    try
    {
      status = loginProcess.loginUser(loginData);
    }
    catch (SQLException e)
    {
      if (e instanceof SQLException)
        throw new ServicePlatformDBException("SQL exception occured: " + e.getMessage());
    }
    return "{\"status\":\"" + status + "\"}";
  }

}
