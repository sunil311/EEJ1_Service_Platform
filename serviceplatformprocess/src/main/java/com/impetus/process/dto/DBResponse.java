package com.impetus.process.dto;

/**
 * @author amitb.kumar
 */
public class DBResponse
{

  /**
	 * 
	 */
  private String result;

  /**
	 * 
	 */
  public DBResponse()
  {
  }

  /**
   * @param result
   */
  public DBResponse(String result)
  {
    this.result = result;
  }

  /**
   * @return
   */
  public String getResult()
  {
    return result;
  }

  /**
   * @param result
   */
  public void setResult(String result)
  {
    this.result = result;
  }

}
