package com.impetus.serviceplatform.web.controller;

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
import com.impetus.process.SysadminProcess;
import com.impetus.process.dto.LoginData;

/**
 * @author amitb.kumar
 */
@Controller
@SessionAttributes("LoggedInUser")
public class LoginController
{

  private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

  @Autowired
  private LoginProcess loginProcess;

  @Autowired
  private SysadminProcess sysadminProcess;

  private String status;

  /**
   * @param loginData
   * @return
   */
  @RequestMapping(value = "/RegisterUser/doLogin", method = RequestMethod.POST)
  public @ResponseBody
  String loginUser(@RequestBody
  LoginData loginData)
  {
    status = loginProcess.loginUser(loginData);
    LOGGER.info("user status :" + status);
    return "{\"status\":\"" + status + "\"}";
  }

}
