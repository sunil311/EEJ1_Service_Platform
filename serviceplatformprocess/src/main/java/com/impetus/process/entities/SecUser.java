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
 * @author ajay.kumar
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

	@Column(name = "displayName")
	private String displayName;

	@Column(name = "companyName")
	private String companyName;

	@Column(name = "houseNo")
	private String houseNo;

	@Column(name = "locality")
	private String locality;

	@Column(name = "state")
	private String state;

	@Column(name = "postCode")
	private String postCode;

	@Column(name = "bankAccountHolder")
	private String bankAccountHolder;

	@Column(name = "bankName")
	private String bankName;

	@Column(name = "branchAddress")
	private String branchAddress;

	@Column(name = "accountNumber")
	private String accountNumber;

	@Column(name = "ifscCode")
	private String ifscCode;

	@Column(name = "facebookURL")
	private String facebookURL;

	@Column(name = "twitterURL")
	private String twitterURL;

	@Column(name = "domainName")
	private String domainName;

	@Column(name = "activated")
	private Boolean activated;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<UserRole> roles;

	public Integer getUserId() {
		return this.userId;
	}

	public SecUser() {
	}

	public SecUser(String password, String username, String firstName,
			String lastName, String email, int roleId, int userTypeId) {
		this.password = password;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;

	}

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

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	@Column(name = "PASSWORD", nullable = false)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "USERNAME")
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "FIRST_NAME", nullable = false)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "LAST_NAME", nullable = false)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "EMAIL", nullable = false)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the roles
	 */
	public List<UserRole> getRoles() {
		return roles;
	}

	/**
	 * @param roles
	 *            the roles to set
	 */
	public void setRoles(List<UserRole> roles) {
		this.roles = roles;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getBankAccountHolder() {
		return bankAccountHolder;
	}

	public void setBankAccountHolder(String bankAccountHolder) {
		this.bankAccountHolder = bankAccountHolder;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getFacebookURL() {
		return facebookURL;
	}

	public void setFacebookURL(String facebookURL) {
		this.facebookURL = facebookURL;
	}

	public String getTwitterURL() {
		return twitterURL;
	}

	public void setTwitterURL(String twitterURL) {
		this.twitterURL = twitterURL;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public Boolean getActivated() {
		return activated;
	}

	public void setActivated(Boolean activated) {
		this.activated = activated;
	}

}
