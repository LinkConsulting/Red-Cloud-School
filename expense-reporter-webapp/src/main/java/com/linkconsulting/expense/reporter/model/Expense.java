package com.linkconsulting.expense.reporter.model;

import java.util.Date;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Expense {
	
	private static final Logger logger = Logger.getLogger(Expense.class.getName());
	
	/* Class members */
	private String name;
	private Date date;
	private String type;
	private String issuer;
	private String receipt;
	private String description;
	private String value;
		
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
	
	public String getReceipt() {
		return receipt;
	}
	
	public void setReceipt(String string) {
		this.receipt = string;
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
	
	/* Class members */
	public String toJson(){
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			logger.warning("Could not generate json mapping from this object.");
			e.printStackTrace();
		}
		
		return null;
	}

}
