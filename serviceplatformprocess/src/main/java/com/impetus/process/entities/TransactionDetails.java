package com.impetus.process.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author amitb.kumar
 */
@Entity
@Table(name = "transaction_details")
public class TransactionDetails
{

  /**
	 * 
	 */
  @Column(name = "TRANSACTION_ID")
  private int transactionId;

  /**
	 * 
	 */
  @Column(name = "AGGREGATOR_ID")
  private String aggregatorId;

  /**
	 * 
	 */
  @Column(name = "PROVIDER_ID")
  private String providerId;

  /**
	 * 
	 */
  @Column(name = "FIELD_PROFESSIONAL_ID")
  private String fieldProfessionalId;

  /**
	 * 
	 */
  @Column(name = "CUSTOMER_ID")
  private String customerId;

  /**
	 * 
	 */
  @Column(name = "AMOUT")
  private int amout;

  /**
	 * 
	 */
  @Column(name = "TRASACTION_DATE")
  private Date trasactionDate;

  /**
   * @return
   */
  public int getTransactionId()
  {
    return transactionId;
  }

  /**
   * @param transactionId
   */
  public void setTransactionId(int transactionId)
  {
    this.transactionId = transactionId;
  }

  /**
   * @return
   */
  public String getAggregatorId()
  {
    return aggregatorId;
  }

  /**
   * @param aggregatorId
   */
  public void setAggregatorId(String aggregatorId)
  {
    this.aggregatorId = aggregatorId;
  }

  /**
   * @return
   */
  public String getProviderId()
  {
    return providerId;
  }

  /**
   * @param providerId
   */
  public void setProviderId(String providerId)
  {
    this.providerId = providerId;
  }

  /**
   * @return
   */
  public String getFieldProfessionalId()
  {
    return fieldProfessionalId;
  }

  /**
   * @param fieldProfessionalId
   */
  public void setFieldProfessionalId(String fieldProfessionalId)
  {
    this.fieldProfessionalId = fieldProfessionalId;
  }

  /**
   * @return
   */
  public String getCustomerId()
  {
    return customerId;
  }

  /**
   * @param customerId
   */
  public void setCustomerId(String customerId)
  {
    this.customerId = customerId;
  }

  /**
   * @return
   */
  public int getAmout()
  {
    return amout;
  }

  /**
   * @param amout
   */
  public void setAmout(int amout)
  {
    this.amout = amout;
  }

  /**
   * @return
   */
  public Date getTrasactionDate()
  {
    return trasactionDate;
  }

  /**
   * @param trasactionDate
   */
  public void setTrasactionDate(Date trasactionDate)
  {
    this.trasactionDate = trasactionDate;
  }

}
