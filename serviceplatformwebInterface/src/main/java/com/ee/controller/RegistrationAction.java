package com.ee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sp.entities.UserInfo;
import com.sp.process.user.RegisterProcess;
/**
 * 
 * @author rakesh.singhania
 *
 */
@Controller
public class RegistrationAction
{
 
  private RegisterProcess registerProcess;
  
  @RequestMapping(value = "/RegisterUser", method = RequestMethod.GET, produces ="text/plain")
  public @ResponseBody String get() throws Exception
  {
    System.out.println("Enter dragon");
    UserInfo registerBean=new UserInfo();
    registerBean.setEmail("rakesh@aa.com");
    registerProcess.registerUser(registerBean);
    return "done";
  }

  public RegisterProcess getRegisterProcess()
  {
    return registerProcess;
  }
  @Autowired
  public void setRegisterProcess(RegisterProcess registerProcess)
  {
    this.registerProcess = registerProcess;
  }

  
}
