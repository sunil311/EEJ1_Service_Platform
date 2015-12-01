package com.impetus.process.dto;

import java.io.Serializable;

/**
 * @author amitb.kumar
 */
public class RequestJSON implements Serializable
{

  /**
	 * 
	 */
  /**
	 * 
	 */
  private static final long serialVersionUID = 8402305622637613993L;

  /**
	 * 
	 */
  private String tenantId;
  /**
	 * 
	 */
  private String tokenId;
  /**
	 * 
	 */
  private String refererId;
  /**
	 * 
	 */
  private String payload;

  /**
   * @param tenantId
   * @param tokenId
   * @param refererId
   * @param payload
   */
  public RequestJSON(String tenantId, String tokenId, String refererId, String payload)
  {
    this.tenantId = tenantId;
    this.tokenId = tokenId;
    this.refererId = refererId;
    this.payload = payload;
  }

  /**
	 * 
	 */
  public RequestJSON()
  {
  }

  /**
   * @return
   */
  public String getTenantId()
  {
    return tenantId;
  }

  /**
   * @param tenantId
   */
  public void setTenantId(String tenantId)
  {
    this.tenantId = tenantId;
  }

  /**
   * @return
   */
  public String getTokenId()
  {
    return tokenId;
  }

  /**
   * @param tokenId
   */
  public void setTokenId(String tokenId)
  {
    this.tokenId = tokenId;
  }

  /**
   * @return
   */
  public String getRefererId()
  {
    return refererId;
  }

  /**
   * @param refererId
   */
  public void setRefererId(String refererId)
  {
    this.refererId = refererId;
  }

  /**
   * @return
   */
  public String getPayload()
  {
    return payload;
  }

  /**
   * @param payload
   */
  public void setPayload(String payload)
  {
    this.payload = payload;
  }
}
