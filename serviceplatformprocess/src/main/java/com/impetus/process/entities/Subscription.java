package com.impetus.process.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author amitb.kumar
 */
@Entity
@Table(name = "SUBSCRIPTION")
public class Subscription
{

  /**
   * @return
   */
  public int getSubscriptionID()
  {
    return subscriptionID;
  }

  /**
   * @param subscriptionID
   */
  public void setSubscriptionID(int subscriptionID)
  {
    this.subscriptionID = subscriptionID;
  }

  /**
   * @return
   */
  public String getSubscriptionType()
  {
    return subscriptionType;
  }

  /**
   * @param subscriptionType
   */
  public void setSubscriptionType(String subscriptionType)
  {
    this.subscriptionType = subscriptionType;
  }

  /**
   * @return
   */
  public String getSubscriptionDesc()
  {
    return subscriptionDesc;
  }

  /**
   * @param subscriptionDesc
   */
  public void setSubscriptionDesc(String subscriptionDesc)
  {
    this.subscriptionDesc = subscriptionDesc;
  }

  /**
	 * 
	 */
  @Column(name = "SUBSCRIPTION_ID")
  private int subscriptionID;
  /**
	 * 
	 */
  @Column(name = "SUBSCRIPTION_TYPE")
  private String subscriptionType;
  /**
	 * 
	 */
  @Column(name = "SUBSCRIPTION_DESCRIPTION")
  private String subscriptionDesc;

}
