package com.linkconsulting.expense.reporter.model;

import java.util.List;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExpenseReport {
	
	private static final Logger logger = Logger.getLogger(ExpenseReport.class.getName());
	
	/* Class members */
	private String id;
	private String name;
	
	private List<Expense> expenses;
	private String state;
	private String description;
	
	/* Getters and Setters */
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Expense> getExpenses() {
		return expenses;
	}
	
	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
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
