package com.impetus.process;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.impetus.process.dao.UserDao;
import com.impetus.process.dto.LoginData;
import com.impetus.process.entities.UserRole;
import com.impetus.process.enums.Role;

public class LoginProcess {
	@Autowired
	private UserDao userDao;

	Logger logger = LoggerFactory.getLogger(getClass());

	public String loginUser(LoginData loginData) throws SQLException {

		String result = "SUCCESS";
		logger.info("Cheking user........");
		List<UserRole> roles = new ArrayList<UserRole>();
		roles.add(userDao.getRoleById(Role.USER.getId()));
		if (userDao.findUser(loginData.getEmail(), loginData.getPassword())!=null) {
			updateUserSessionData();
		} else {
			logger.info("Login user........USER DO NOT EXISTS");
			result = "USER DO NOT EXISTS";
		}
		return result;
	}

	private void updateUserSessionData() {
		// TODO Auto-generated method stub
	}
}
