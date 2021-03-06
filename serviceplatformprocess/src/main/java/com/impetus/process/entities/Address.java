package com.impetus.process.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Address generated by hbm2java
 */
/**
 * @author amitb.kumar
 */
@Entity
@Table(name = "ADDRESS")
@GenericGenerator(name = "Address", strategy = "org.hibernate.id.enhanced.TableGenerator", parameters = {
    @Parameter(name = "segment_value", value = "ADDRESS"),
    @Parameter(name = "increment_size", value = "10"),
    @Parameter(name = "optimizer", value = "pooled")})
public class Address implements java.io.Serializable
{

  /**
   * 
   */
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  /**
   * 
   */
  @Id
  @GeneratedValue(generator = "Address")
  @Column(name = "ADDRESS_ID")
  private Integer addressId;
  /**
	 * 
	 */
  private String line1;
  /**
	 * 
	 */
  private String line2;
  /**
	 * 
	 */
  private String city;
  /**
	 * 
	 */
  private String state;
  /**
	 * 
	 */
  private String zip;

  /**
	 * 
	 */
  public Address()
  {
  }

  /**
   * @param line1
   * @param line2
   * @param city
   * @param state
   * @param zip
   */
  public Address(String line1, String line2, String city, String state, String zip)
  {
    this.line1 = line1;
    this.line2 = line2;
    this.city = city;
    this.state = state;
    this.zip = zip;
  }

  /**
   * @return
   */
  public Integer getAddressId()
  {
    return this.addressId;
  }

  /**
   * @param addressId
   */
  public void setAddressId(Integer addressId)
  {
    this.addressId = addressId;
  }

  /**
   * @return
   */
  @Column(name = "LINE1", nullable = false, length = 100)
  public String getLine1()
  {
    return this.line1;
  }

  /**
   * @param line1
   */
  public void setLine1(String line1)
  {
    this.line1 = line1;
  }

  /**
   * @return
   */
  @Column(name = "LINE2", nullable = false, length = 100)
  public String getLine2()
  {
    return this.line2;
  }

  /**
   * @param line2
   */
  public void setLine2(String line2)
  {
    this.line2 = line2;
  }

  /**
   * @return
   */
  @Column(name = "CITY", nullable = false, length = 100)
  public String getCity()
  {
    return this.city;
  }

  /**
   * @param city
   */
  public void setCity(String city)
  {
    this.city = city;
  }

  /**
   * @return
   */
  @Column(name = "STATE", nullable = false, length = 50)
  public String getState()
  {
    return this.state;
  }

  /**
   * @param state
   */
  public void setState(String state)
  {
    this.state = state;
  }

  /**
   * @return
   */
  @Column(name = "ZIP", nullable = false, length = 7)
  public String getZip()
  {
    return this.zip;
  }

  /**
   * @param zip
   */
  public void setZip(String zip)
  {
    this.zip = zip;
  }

}
