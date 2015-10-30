package com.impetus.process.dto;

import java.io.Serializable;

public class RequestJSON implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8402305622637613993L;

	private String tenantId;
	private String tokenId;
	private String refererId;
	private String payload;

	public RequestJSON(String tenantId, String tokenId, String refererId,
			String payload) {
		this.tenantId = tenantId;
		this.tokenId = tokenId;
		this.refererId = refererId;
		this.payload = payload;
	}

	public RequestJSON() {
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public String getRefererId() {
		return refererId;
	}

	public void setRefererId(String refererId) {
		this.refererId = refererId;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}
}
