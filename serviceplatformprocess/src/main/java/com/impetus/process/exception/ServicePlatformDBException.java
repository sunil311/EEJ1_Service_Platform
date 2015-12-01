package com.impetus.process.exception;

import java.sql.SQLException;

/**
 * @author amitb.kumar
 */
public class ServicePlatformDBException extends SQLException
{
  /**
	 * 
	 */
  private static final long serialVersionUID = 1L;

  /**
   * @param message
   */
  public ServicePlatformDBException(String message)
  {
    super(message);
  }

}
