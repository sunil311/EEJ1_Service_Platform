package com.sp.entities;

// Generated Oct 9, 2015 4:20:36 PM by Hibernate Tools 4.0.0

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * SecUser generated by hbm2java
 */
@Entity
@Table(name = "sec_user", catalog = "Service_Source", uniqueConstraints = {
		@UniqueConstraint(columnNames = "ROLE_ID"),
		@UniqueConstraint(columnNames = "USER_TYPE_ID") })
public class SecUser implements java.io.Serializable {

	private Integer userId;
	private byte[] enabled;
	private String externalCode;
	private Integer failedLoginAttempts;
	private Integer failedPsswdRecoveryAttempts;
	private String password;
	private Date softLockExpires;
	private byte[] temporaryPassword;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private int roleId;
	private int userTypeId;
	private Integer aggregatorId;

	public SecUser() {
	}

	public SecUser(String password, String username, String firstName,
			String lastName, String email, int roleId, int userTypeId) {
		this.password = password;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.roleId = roleId;
		this.userTypeId = userTypeId;
	}

	public SecUser(byte[] enabled, String externalCode,
			Integer failedLoginAttempts, Integer failedPsswdRecoveryAttempts,
			String password, Date softLockExpires, byte[] temporaryPassword,
			String username, String firstName, String lastName, String email,
			int roleId, int userTypeId, Integer aggregatorId) {
		this.enabled = enabled;
		this.externalCode = externalCode;
		this.failedLoginAttempts = failedLoginAttempts;
		this.failedPsswdRecoveryAttempts = failedPsswdRecoveryAttempts;
		this.password = password;
		this.softLockExpires = softLockExpires;
		this.temporaryPassword = temporaryPassword;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.roleId = roleId;
		this.userTypeId = userTypeId;
		this.aggregatorId = aggregatorId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "USER_ID", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "ENABLED")
	public byte[] getEnabled() {
		return this.enabled;
	}

	public void setEnabled(byte[] enabled) {
		this.enabled = enabled;
	}

	@Column(name = "EXTERNAL_CODE")
	public String getExternalCode() {
		return this.externalCode;
	}

	public void setExternalCode(String externalCode) {
		this.externalCode = externalCode;
	}

	@Column(name = "FAILED_LOGIN_ATTEMPTS")
	public Integer getFailedLoginAttempts() {
		return this.failedLoginAttempts;
	}

	public void setFailedLoginAttempts(Integer failedLoginAttempts) {
		this.failedLoginAttempts = failedLoginAttempts;
	}

	@Column(name = "FAILED_PSSWD_RECOVERY_ATTEMPTS")
	public Integer getFailedPsswdRecoveryAttempts() {
		return this.failedPsswdRecoveryAttempts;
	}

	public void setFailedPsswdRecoveryAttempts(
			Integer failedPsswdRecoveryAttempts) {
		this.failedPsswdRecoveryAttempts = failedPsswdRecoveryAttempts;
	}

	@Column(name = "PASSWORD", nullable = false)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "SOFT_LOCK_EXPIRES", length = 8)
	public Date getSoftLockExpires() {
		return this.softLockExpires;
	}

	public void setSoftLockExpires(Date softLockExpires) {
		this.softLockExpires = softLockExpires;
	}

	@Column(name = "TEMPORARY_PASSWORD")
	public byte[] getTemporaryPassword() {
		return this.temporaryPassword;
	}

	public void setTemporaryPassword(byte[] temporaryPassword) {
		this.temporaryPassword = temporaryPassword;
	}

	@Column(name = "USERNAME", nullable = false)
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

	@Column(name = "ROLE_ID", unique = true, nullable = false)
	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Column(name = "USER_TYPE_ID", unique = true, nullable = false)
	public int getUserTypeId() {
		return this.userTypeId;
	}

	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}

	@Column(name = "AGGREGATOR_ID")
	public Integer getAggregatorId() {
		return this.aggregatorId;
	}

	public void setAggregatorId(Integer aggregatorId) {
		this.aggregatorId = aggregatorId;
	}

}
