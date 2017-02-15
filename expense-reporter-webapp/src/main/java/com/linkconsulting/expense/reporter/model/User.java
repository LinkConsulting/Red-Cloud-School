package com.linkconsulting.expense.reporter.model;

import java.util.List;

public class User {
	
	/* Class members */
	private List<ExpenseReport> expenseReports;
	private String department;
	private String profile;
	
	private String username;
	private String password;
	private String name;
	
	/* Getters and Setters */
	public List<ExpenseReport> getExpenseReports() {
		return expenseReports;
	}
	
	public void setExpenseReports(List<ExpenseReport> expenseReports) {
		this.expenseReports = expenseReports;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getProfile() {
		return profile;
	}
	
	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
