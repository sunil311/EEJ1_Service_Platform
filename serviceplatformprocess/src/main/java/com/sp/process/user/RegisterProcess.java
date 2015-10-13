package com.sp.process.user;

import org.springframework.beans.factory.annotation.Autowired;

import com.sp.dao.UserDao;
import com.sp.entities.SecUser;
import com.sp.infos.UserData;

/**
 * 
 * @author rakesh.singhania
 * 
 */
public class RegisterProcess {

	@Autowired
	private UserDao userDao;

	public String registerUser(UserData userData) {
		SecUser secUser = new SecUser();
		secUser.setEmail(userData.getEmail());
		secUser.setFirstName(userData.getFirstName());
		secUser.setLastName(userData.getLastName());
		secUser.setPassword(userData.getPassword());
		secUser.setUsername(userData.getEmail());
		try {
			if (userDao.findUserByEmail(userData.getEmail()) == null) {
				userDao.save(secUser);
			} else {
				return "EMAIL ALREADY IN USE";
			}
		} catch (Exception e) {
			System.out.println("Not success");
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
