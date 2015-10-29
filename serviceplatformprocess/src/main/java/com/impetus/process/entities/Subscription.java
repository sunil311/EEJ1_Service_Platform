package com.impetus.process.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SUBSCRIPTION")
public class Subscription {

	@Column(name = "SUBSCRIPTION_ID")
	private int Subscription_ID;
	@Column(name = "SUBSCRIPTION_TYPE")
	private String Subscription_Type;
	@Column(name = "SUBSCRIPTION_DESCRIPTION")
	private String Subscription_Description;

	public int getSubscription_ID() {
		return Subscription_ID;
	}

	public void setSubscription_ID(int subscription_ID) {
		Subscription_ID = subscription_ID;
	}

	public String getSubscription_Type() {
		return Subscription_Type;
	}

	public void setSubscription_Type(String subscription_Type) {
		Subscription_Type = subscription_Type;
	}

	public String getSubscription_Description() {
		return Subscription_Description;
	}

	public void setSubscription_Description(String subscription_Description) {
		Subscription_Description = subscription_Description;
	}

}
