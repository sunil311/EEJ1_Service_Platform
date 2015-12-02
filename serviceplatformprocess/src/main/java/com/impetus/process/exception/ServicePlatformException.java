package com.impetus.process.exception;

/**
 * @author amitb.kumar
 *
 */
public class ServicePlatformException extends Exception
{
  /**
   * 
   */
  private static final long serialVersionUID = -5307459020495115271L;

  /**
   * @param message
   */
  public ServicePlatformException(String message)
  {
    super(message);
  }

  /**
   * @param cause
   */
  public ServicePlatformException(Throwable cause)
  {
    super(cause);
  }

  /**
   * @param message
   * @param cause
   */
  public ServicePlatformException(String message, Throwable cause)
  {
    super(message, cause);
  }
}
