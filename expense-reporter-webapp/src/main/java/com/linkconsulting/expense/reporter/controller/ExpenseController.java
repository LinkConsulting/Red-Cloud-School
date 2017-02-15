package com.linkconsulting.expense.reporter.controller;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class ExpenseController {
	
	/* Class members */
	private String name;
	private Date date;
	private String type;
	private String issuer;
	private String description;
	private String value;
	private String receipt;
	
	/* Getters and Setters */
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getIssuer() {
		return issuer;
	}
	
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getReceipt() {
		return receipt;
	}
	
	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}
	
	/* Class methods */
	
}
