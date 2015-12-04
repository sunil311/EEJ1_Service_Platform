package com.impetus.process.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * @author amitb.kumar
 */
@Entity
@Table(name = "SEC_USER")
@GenericGenerator(name = "SecUser", strategy = "org.hibernate.id.enhanced.TableGenerator", parameters = {
		@Parameter(name = "segment_value", value = "SEC_USER"),
		@Parameter(name = "increment_size", value = "10"),
		@Parameter(name = "optimizer", value = "pooled") })
public class SecUser implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "SecUser", strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private Integer userId;

	@Column(name = "tenantId")
	private String tenantId;

	private String password;

	private String username;

	private String firstName;

	private String lastName;

	private String email;

	@Column(name = "mobile")
	private String mobile;

	/**
	 * 
	 */
	@Column(name = "displayName")
	private String displayName;

	/**
	 * 
	 */
	@Column(name = "companyName")
	private String companyName;

	/**
	 * 
	 */
	@Column(name = "houseNo")
	private String houseNo;

	/**
	 * 
	 */
	@Column(name = "locality")
	private String locality;

	/**
	 * 
	 */
	@Column(name = "state")
	private String state;

	/**
	 * 
	 */
	@Column(name = "postCode")
	private String postCode;

	/**
	 * 
	 */
	@Column(name = "bankAccountHolder")
	private String bankAccountHolder;

	/**
	 * 
	 */
	@Column(name = "bankName")
	private String bankName;

	/**
	 * 
	 */
	@Column(name = "branchAddress")
	private String branchAddress;

	/**
	 * 
	 */
	@Column(name = "accountNumber")
	private String accountNumber;

	/**
	 * 
	 */
	@Column(name = "ifscCode")
	private String ifscCode;

	/**
	 * 
	 */
	@Column(name = "facebookURL")
	private String facebookURL;

	/**
	 * 
	 */
	@Column(name = "twitterURL")
	private String twitterURL;

	/**
	 * 
	 */
	@Column(name = "domainName")
	private String domainName;

	/**
	 * 
	 */
	@Column(name = "activated")
	private Boolean activated;

	/**
   * 
   */
	@Column(name = "template")
	private int template;

	/**
	 * 
	 */
	@ManyToMany(fetch = FetchType.EAGER)
	private List<UserRole> roles;

	/**
	 * @return
	 */
	public Integer getUserId() {
		return this.userId;
	}

	/**
	 * 
	 */
	public SecUser() {
	}

	/**
	 * @param password
	 * @param username
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param roleId
	 * @param userTypeId
	 */
	public SecUser(String password, String username, String firstName,
			String lastName, String email, int roleId, int userTypeId) {
		this.password = password;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;

	}

	/**
	 * @param enabled
	 * @param externalCode
	 * @param failedLoginAttempts
	 * @param failedPsswdRecoveryAttempts
	 * @param password
	 * @param softLockExpires
	 * @param temporaryPassword
	 * @param username
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param roleId
	 * @param userTypeId
	 * @param aggregatorId
	 */
	public SecUser(byte enabled, String externalCode,
			Integer failedLoginAttempts, Integer failedPsswdRecoveryAttempts,
			String password, Date softLockExpires, byte[] temporaryPassword,
			String username, String firstName, String lastName, String email,
			int roleId, int userTypeId, Integer aggregatorId) {

		this.password = password;

		// TODO:setting email as username for now
		this.username = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;

	}

	/**
	 * @param userId
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return
	 */
	public String getTenantId() {
		return tenantId;
	}

	/**
	 * @param tenantId
	 */
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	/**
	 * @return
	 */
	@Column(name = "PASSWORD", nullable = false)
	public String getPassword() {
		return this.password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return
	 */
	@Column(name = "USERNAME")
	public String getUsername() {
		return this.username;
	}

	/**
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return
	 */
	@Column(name = "FIRST_NAME", nullable = false)
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return
	 */
	@Column(name = "LAST_NAME", nullable = false)
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return
	 */
	@Column(name = "EMAIL", nullable = false)
	public String getEmail() {
		return this.email;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the roles
	 */
	/**
	 * @return
	 */
	public List<UserRole> getRoles() {
		return roles;
	}

	/**
	 * @param roles
	 *            the roles to set
	 */
	/**
	 * @param roles
	 */
	public void setRoles(List<UserRole> roles) {
		this.roles = roles;
	}

	/**
	 * @return
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * @param displayName
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * @return
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return
	 */
	public String getHouseNo() {
		return houseNo;
	}

	/**
	 * @param houseNo
	 */
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	/**
	 * @return
	 */
	public String getLocality() {
		return locality;
	}

	/**
	 * @param locality
	 */
	public void setLocality(String locality) {
		this.locality = locality;
	}

	/**
	 * @return
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return
	 */
	public String getPostCode() {
		return postCode;
	}

	/**
	 * @param postCode
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	/**
	 * @return
	 */
	public String getBankAccountHolder() {
		return bankAccountHolder;
	}

	/**
	 * @param bankAccountHolder
	 */
	public void setBankAccountHolder(String bankAccountHolder) {
		this.bankAccountHolder = bankAccountHolder;
	}

	/**
	 * @return
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * @param bankName
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * @return
	 */
	public String getBranchAddress() {
		return branchAddress;
	}

	/**
	 * @param branchAddress
	 */
	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	/**
	 * @return
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return
	 */
	public String getIfscCode() {
		return ifscCode;
	}

	/**
	 * @param ifscCode
	 */
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	/**
	 * @return
	 */
	public String getFacebookURL() {
		return facebookURL;
	}

	/**
	 * @param facebookURL
	 */
	public void setFacebookURL(String facebookURL) {
		this.facebookURL = facebookURL;
	}

	/**
	 * @return
	 */
	public String getTwitterURL() {
		return twitterURL;
	}

	/**
	 * @param twitterURL
	 */
	public void setTwitterURL(String twitterURL) {
		this.twitterURL = twitterURL;
	}

	/**
	 * @return
	 */
	public String getDomainName() {
		return domainName;
	}

	/**
	 * @param domainName
	 */
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	/**
	 * @return
	 */
	public Boolean getActivated() {
		return activated;
	}

	/**
	 * @param activated
	 */
	public void setActivated(Boolean activated) {
		this.activated = activated;
	}

	/**
	 * @return
	 */
	public int getTemplate() {
		return template;
	}

	/**
	 * @param template
	 */
	public void setTemplate(int template) {
		this.template = template;
	}

}
