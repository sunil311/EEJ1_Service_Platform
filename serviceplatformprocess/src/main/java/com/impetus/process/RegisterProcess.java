package com.impetus.process;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impetus.process.dao.UserDao;
import com.impetus.process.dto.UserData;
import com.impetus.process.entities.SecUser;
import com.impetus.process.entities.UserRole;
import com.impetus.process.enums.Role;

/**
 * @author rakesh.singhania
 */
@Service("registerProcess")
public class RegisterProcess {

	@Autowired
	public UserDao userDao;

	Logger logger = LoggerFactory.getLogger(getClass());

	public String registerUser(UserData userData) throws SQLException {

		String result = "SUCCESS";
		logger.info("Regestring user........");
		SecUser secUser = new SecUser();
		secUser.setEmail(userData.getEmail());
		secUser.setFirstName(userData.getFirstName());
		secUser.setLastName(userData.getLastName());
		secUser.setPassword(userData.getPassword());
		secUser.setUsername(userData.getEmail());
		secUser.setMobile(userData.getMobile());
		secUser.setDisplayName(userData.getDisplayName());
		secUser.setCompanyName(userData.getCompanyName());
		secUser.setHouseNo(userData.getHouseNo());
		secUser.setLocality(userData.getLocality());
		secUser.setState(userData.getState());
		secUser.setPostCode(userData.getPostCode());
		secUser.setBankAccountHolder(userData.getBankAccountHolder());
		secUser.setBankName(userData.getBankName());
		secUser.setBranchAddress(userData.getBranchAddress());
		secUser.setAccountNumber(userData.getAccountNumber());
		secUser.setIfscCode(userData.getIfscCode());
		secUser.setFacebookURL(userData.getFacebookURL());
		secUser.setTwitterURL(userData.getTwitterURL());
		secUser.setDomainName(userData.getDomainName());
		secUser.setTenantId(generateTenantId());
		secUser.setActivated(false);
		
		if(StringIsEmpty(secUser.getFirstName())){
			return "First Name is mandatory";
		}
		
		if(StringIsEmpty(secUser.getLastName())){
			return "Last Name is mandatory";
		}
		
		if(StringIsEmpty(secUser.getPassword())){
			return "Password is mandatory";
		}
		
		if(StringIsEmpty(secUser.getEmail())){
			return "Email is mandatory";
		}
		
		if(StringIsEmpty(secUser.getMobile())){
			return "Mobile Number is mandatory";
		}

		List<UserRole> roles = new ArrayList<UserRole>();
		roles.add(userDao.getRoleById(Role.USER.getId()));
		secUser.setRoles(roles);
		if (!userDao.userExists(userData.getEmail())) {
			userDao.save(secUser);
		} else {
			logger.info("Regestring user........EMAIL ALREADY IN USE");
			result = "EMAIL ALREADY IN USE";
		}
		return result;
	}

	private boolean StringIsEmpty(String StringName) {
		return (StringName == null || StringName.length() == 0);
	}

	public boolean checkEmailExists(UserData userData) {
		return userDao.userExists(userData.getEmail());

	}

	/**
	 * @return tenant Id
	 */
	private String generateTenantId() {
		String generatedTenantId = null;
		List<String> existingTenantIds = userDao.getAllTenantIds();
		while (doesTenanteIdExists(existingTenantIds, generatedTenantId)) {
			generatedTenantId = UUID.randomUUID().toString();
		}
		return generatedTenantId;
	}

	/**
	 * @param existingTenantIds
	 * @param generatedTenantId
	 * @return
	 */
	private boolean doesTenanteIdExists(List<String> existingTenantIds,
			String generatedTenantId) {
		return generatedTenantId == null ? true : existingTenantIds
				.contains(generatedTenantId);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
