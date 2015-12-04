package com.impetus.process.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "TENANT_DATABASE_DETAILS")
@GenericGenerator(name = "TenantDatabaseMetadata", strategy = "org.hibernate.id.enhanced.TableGenerator", parameters = {
    @Parameter(name = "segment_value", value = "TENANT_DATABASE_DETAILS"),
    @Parameter(name = "increment_size", value = "10"),
    @Parameter(name = "optimizer", value = "pooled")})
public class TenantDatabaseMetadata implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "TenantDatabaseMetadata", strategy = GenerationType.IDENTITY)
	@Column(name = "DATABASE_DETAILS_ID")
	private Integer dbDetailsId;

	@Column(name = "DATABASE_HOST_NAME")
	private String dbHostName;

	@Column(name = "DATABASE_HOST_PORT")
	private String dbHostPort;

	@Column(name = "DATABASE_NAME")
	private String dbName;

	@Column(name = "DATABASE_USER_NAME")
	private String dbUserName;

	@Column(name = "DATABASE_PASSWORD")
	private String dbPassword;

	@Column(name = "TENANT_ID")
	private String tenantId;

	/**
	 * @return the dbUserName
	 */
	public String getDbUserName() {
		return dbUserName;
	}

	/**
	 * @param dbUserName
	 *            the dbUserName to set
	 */
	public void setDbUserName(String dbUserName) {
		this.dbUserName = dbUserName;
	}

	/**
	 * @return the dbPassword
	 */
	public String getDbPassword() {
		return dbPassword;
	}

	/**
	 * @param dbPassword
	 *            the dbPassword to set
	 */
	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	/**
	 * @return the dbDetailsId
	 */
	public Integer getDbDetailsId() {
		return dbDetailsId;
	}

	/**
	 * @param dbDetailsId
	 *            the dbDetailsId to set
	 */
	public void setDbDetailsId(Integer dbDetailsId) {
		this.dbDetailsId = dbDetailsId;
	}

	/**
	 * @return the dbHostName
	 */
	public String getDbHostName() {
		return dbHostName;
	}

	/**
	 * @param dbHostName
	 *            the dbHostName to set
	 */
	public void setDbHostName(String dbHostName) {
		this.dbHostName = dbHostName;
	}

	/**
	 * @return the dbHostPort
	 */
	public String getDbHostPort() {
		return dbHostPort;
	}

	/**
	 * @param dbHostPort
	 *            the dbHostPort to set
	 */
	public void setDbHostPort(String dbHostPort) {
		this.dbHostPort = dbHostPort;
	}

	/**
	 * @return the dbName
	 */
	public String getDbName() {
		return dbName;
	}

	/**
	 * @param dbName
	 *            the dbName to set
	 */
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	/**
	 * @return the tenantId
	 */
	public String getTenantId() {
		return tenantId;
	}

	/**
	 * @param tenantId
	 *            the tenantId to set
	 */
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

}
