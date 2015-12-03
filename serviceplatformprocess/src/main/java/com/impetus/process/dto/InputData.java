package com.impetus.process.dto;

/**
 * @author amitb.kumar
 */
public class InputData {

	private String dbURL;
	private String dbName;
	private String dbUserName;
	private String dbPassword;
	private String dbHostName;
	private String dbPort;

	public String getDbHostName() {
		return dbHostName;
	}

	public void setDbHostName(String dbHostName) {
		this.dbHostName = dbHostName;
	}

	public String getDbPort() {
		return dbPort;
	}

	public void setDbPort(String dbPort) {
		this.dbPort = dbPort;
	}

	/**
	 * @return
	 */
	public String getDbURL() {
		return dbURL;
	}

	/**
	 * @param dbURL
	 */
	public void setDbURL(String dbURL) {
		this.dbURL = dbURL;
	}

	/**
	 * @return
	 */
	public String getDbName() {
		return dbName;
	}

	/**
	 * @param dbName
	 */
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	/**
	 * @return
	 */
	public String getDbUserName() {
		return dbUserName;
	}

	/**
	 * @param dbUserName
	 */
	public void setDbUserName(String dbUserName) {
		this.dbUserName = dbUserName;
	}

	/**
	 * @return
	 */
	public String getDbPassword() {
		return dbPassword;
	}

	/**
	 * @param dbPassword
	 */
	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

}
