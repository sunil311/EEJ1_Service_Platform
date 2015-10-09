package com.ee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sp.entities.SecUser;
import com.sp.process.user.RegisterProcess;

@Controller
public class RegistrationAction {

	@Autowired
	private RegisterProcess registerProcess;

	@RequestMapping(value = "/RegisterUser", method = RequestMethod.POST)
	public @ResponseBody
	String postService(@RequestBody SecUser person) {
		System.out.println("Enter dragon");

		SecUser registerBean = new SecUser();
		registerBean.setEmail("rakesh@aa.com");
		try {
			// TODO : To be updated
			// registerProcess.registerUser(registerBean);
		} catch (Exception e) {
			// TODO Add Logger here
			e.printStackTrace();
		}
		return "done";
	}

	public RegisterProcess getRegisterProcess() {
		return registerProcess;
	}

	public void setRegisterProcess(RegisterProcess registerProcess) {
		this.registerProcess = registerProcess;
	}

}
