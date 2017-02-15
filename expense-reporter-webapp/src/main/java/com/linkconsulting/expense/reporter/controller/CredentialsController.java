package com.linkconsulting.expense.reporter.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value="credentials")
@RequestScoped
public class CredentialsController {

	/* Class members */
	private String username;
	private String password;
	
	/* Getters and Setters */
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
}
