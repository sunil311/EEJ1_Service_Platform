package com.impetus.process.dto;

public class DbProfileData
{
  private int userId;
  private String dbName;
  private String dbType;  
  private String hostName;
  private String portNumber;
  private String userName;
  private String password;
  private String email;

  public String getDbName()
  {
    return dbName;
  }

  public void setDbName(String dbName)
  {
    this.dbName = dbName;
  }

  public String getHostName()
  {
    return hostName;
  }

  public void setHostName(String hostName)
  {
    this.hostName = hostName;
  }

  public String getPortNumber()
  {
    return portNumber;
  }

  public void setPortNumber(String portNumber)
  {
    this.portNumber = portNumber;
  }

  public String getUserName()
  {
    return userName;
  }

  public void setUserName(String userName)
  {
    this.userName = userName;
  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public int getUserId()
  {
    return userId;
  }

  public void setUserId(int userId)
  {
    this.userId = userId;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getDbType()
  {
    return dbType;
  }

  public void setDbType(String dbType)
  {
    this.dbType = dbType;
  }

}
