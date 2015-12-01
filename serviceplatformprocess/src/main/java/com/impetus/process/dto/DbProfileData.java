package com.impetus.process.dto;

/**
 * @author amitb.kumar
 */
public class DbProfileData
{
  /**
   * 
   */
  private int userId;
  /**
   * 
   */
  private String dbName;
  /**
   * 
   */
  private String dbType;
  /**
   * 
   */
  private String hostName;
  /**
   * 
   */
  private String portNumber;
  /**
   * 
   */
  private String userName;
  /**
   * 
   */
  private String password;
  /**
   * 
   */
  private String email;

  /**
   * @return
   */
  public String getDbName()
  {
    return dbName;
  }

  /**
   * @param dbName
   */
  public void setDbName(String dbName)
  {
    this.dbName = dbName;
  }

  /**
   * @return
   */
  public String getHostName()
  {
    return hostName;
  }

  /**
   * @param hostName
   */
  public void setHostName(String hostName)
  {
    this.hostName = hostName;
  }

  /**
   * @return
   */
  public String getPortNumber()
  {
    return portNumber;
  }

  /**
   * @param portNumber
   */
  public void setPortNumber(String portNumber)
  {
    this.portNumber = portNumber;
  }

  /**
   * @return
   */
  public String getUserName()
  {
    return userName;
  }

  /**
   * @param userName
   */
  public void setUserName(String userName)
  {
    this.userName = userName;
  }

  /**
   * @return
   */
  public String getPassword()
  {
    return password;
  }

  /**
   * @param password
   */
  public void setPassword(String password)
  {
    this.password = password;
  }

  /**
   * @return
   */
  public int getUserId()
  {
    return userId;
  }

  /**
   * @param userId
   */
  public void setUserId(int userId)
  {
    this.userId = userId;
  }

  /**
   * @return
   */
  public String getEmail()
  {
    return email;
  }

  /**
   * @param email
   */
  public void setEmail(String email)
  {
    this.email = email;
  }

  /**
   * @return
   */
  public String getDbType()
  {
    return dbType;
  }

  /**
   * @param dbType
   */
  public void setDbType(String dbType)
  {
    this.dbType = dbType;
  }

}
