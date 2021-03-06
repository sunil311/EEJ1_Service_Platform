package com.impetus.serviceplatform.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.impetus.process.RegisterProcess;
import com.impetus.process.dto.UserData;

/**
 * @author amitb.kumar
 */
@Controller
public class RegistrationController
{
  @Autowired
  private RegisterProcess registerProcess;
  /**
   * 
   */
  private String status;

  /**
   * @param userData
   * @return
   */
  @RequestMapping(value = "/RegisterUser/signUp", method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.OK)
  public @ResponseBody
  String postService(@RequestBody
  UserData userData)
  {
    status = registerProcess.registerUser(userData);
    return "{\"status\":\"" + status + "\"}";
  }

  /**
   * @param userData
   * @return
   */
  @RequestMapping(value = "/RegisterUser/checkEmail", method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.OK)
  public @ResponseBody
  String getService(@RequestBody
  UserData userData)
  {
    boolean isUserExists = false;
    isUserExists = registerProcess.checkEmailExists(userData);
    if (!isUserExists)
      return "{\"status\":\"" + "SUCCESS" + "\"}";
    else
      return "{\"status\":\"" + "EMAIL ALREADY IN USE" + "\"}";
  }

}
