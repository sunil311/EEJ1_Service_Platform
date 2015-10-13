package com.ee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sp.infos.UserData;
import com.sp.process.user.RegisterProcess;

@Controller
public class RegistrationAction {

	@Autowired
	private RegisterProcess registerProcess;
	private String status;
	@RequestMapping(value = "/RegisterUser", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody
	UserData postService(@RequestBody UserData userData) {
		try {
			status = registerProcess.registerUser(userData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*if(status.equals("SUCCESS"))
			
		return HttpStatus.OK;
		else
			return HttpStatus.;*/
		
		/* JSONObject obj = new JSONObject();

	      obj.put("name", "foo");
	      obj.put("num", new Integer(100));
	      obj.put("balance", new Double(1000.21));
	      obj.put("is_vip", new Boolean(true));

	      System.out.print(obj);*/
	      return userData;
	}

	public RegisterProcess getRegisterProcess() {
		return registerProcess;
	}

	public void setRegisterProcess(RegisterProcess registerProcess) {
		this.registerProcess = registerProcess;
	}

}
