package com.impetus.process.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SUBSCRIPTION")
public class Subscription {

	public int getSubscriptionID() {
		return subscriptionID;
	}

	public void setSubscriptionID(int subscriptionID) {
		this.subscriptionID = subscriptionID;
	}

	public String getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(String subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	public String getSubscriptionDesc() {
		return subscriptionDesc;
	}

	public void setSubscriptionDesc(String subscriptionDesc) {
		this.subscriptionDesc = subscriptionDesc;
	}

	@Column(name = "SUBSCRIPTION_ID")
	private int subscriptionID;
	@Column(name = "SUBSCRIPTION_TYPE")
	private String subscriptionType;
	@Column(name = "SUBSCRIPTION_DESCRIPTION")
	private String subscriptionDesc;

}
