package com.impetus.process;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.impetus.process.dao.UserDao;
import com.impetus.process.dto.UserData;
import com.impetus.process.entities.SecUser;

/**
 * 
 * @author rakesh.singhania
 * 
 */
public class RegisterProcess {

	@Autowired
	private UserDao userDao;
	Logger logger = LoggerFactory.getLogger(getClass());
	public String registerUser(UserData userData) {
		SecUser secUser = new SecUser();
		secUser.setEmail(userData.getEmail());
		secUser.setFirstName(userData.getFirstName());
		secUser.setLastName(userData.getLastName());
		secUser.setPassword(userData.getPassword());
		secUser.setUsername(userData.getEmail());
		try {
			if (!userDao.userExists(userData.getEmail())) {
				userDao.save(secUser);
			} else {
				return "EMAIL ALREADY IN USE";
			}
		} catch (Exception e) {
			logger.info("Not success");
			e.printStackTrace();
			return "FAILED";
		}
		return "SUCCESS";
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
