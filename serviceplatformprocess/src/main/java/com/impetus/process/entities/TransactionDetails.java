package com.impetus.process.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "transaction_details")
public class TransactionDetails {

	@Column(name = "TRANSACTION_ID")
	private int transactionId;
	
	@Column(name = "AGGREGATOR_ID")
	private String aggregatorId;
	
	@Column(name = "PROVIDER_ID")
	private String providerId;

	@Column(name = "FIELD_PROFESSIONAL_ID")
	private String fieldProfessionalId;

	@Column(name = "CUSTOMER_ID")
	private String customerId;

	@Column(name = "AMOUT")
	private int amout;

	@Column(name = "TRASACTION_DATE")
	private Date trasactionDate;

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getAggregatorId() {
		return aggregatorId;
	}

	public void setAggregatorId(String aggregatorId) {
		this.aggregatorId = aggregatorId;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getFieldProfessionalId() {
		return fieldProfessionalId;
	}

	public void setFieldProfessionalId(String fieldProfessionalId) {
		this.fieldProfessionalId = fieldProfessionalId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public int getAmout() {
		return amout;
	}

	public void setAmout(int amout) {
		this.amout = amout;
	}

	public Date getTrasactionDate() {
		return trasactionDate;
	}

	public void setTrasactionDate(Date trasactionDate) {
		this.trasactionDate = trasactionDate;
	}
	
	
}
