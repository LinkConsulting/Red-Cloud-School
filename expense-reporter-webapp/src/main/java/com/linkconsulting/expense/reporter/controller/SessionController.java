package com.linkconsulting.expense.reporter.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.linkconsulting.expense.reporter.model.AppMock;
import com.linkconsulting.expense.reporter.model.Expense;
import com.linkconsulting.expense.reporter.model.ExpenseReport;
import com.linkconsulting.expense.reporter.model.User;

@Named
@SessionScoped
public class SessionController implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1395822007032321528L;
	private static final Logger logger = Logger.getLogger(SessionController.class.getName());
	
	/* Class members */
	@Inject
	private CredentialsController credentials;
	
	@Inject
	private ReportController reports;
	
	@Inject
	private ExpenseController expenses;
	
	@Inject
	private ApprovalsController approvals;
	
	private User user = null;
	private ExpenseReport expenseReport = null;
	private Expense expense = null;
	
	/* Getters and Setters */
	public User getUser(){
		return user;
	}
	
	public ExpenseReport getExpenseReport() {
		return expenseReport;
	}
	
	public void setExpenseReport(ExpenseReport expenseReport) {
		if(expenseReport != null) logger.info("Selected the following Expense Report:\n" + expenseReport.toJson());
		this.expenseReport = expenseReport;
	}

	public Expense getExpense() {
		return expense;
	}

	public void setExpense(Expense expense) {
		if(expense != null) logger.info("Selected the following Expense:\n" + expense.toJson());
		this.expense = expense;
	}

	/* Class methods */
	
	/*
	 * Session control methods
	 */
	public boolean isLoggedIn() {
		return user != null;
	}
	
	public String login(){
		String username = credentials.getUsername();
		String password = credentials.getPassword();
		
		if((user = AppMock.getUser(username, password)) != null){
			logger.info("Username: " + username + " - logged in.");
			return "/expenses.jsf?faces-redirect=true";
		} else {
			logger.info("Username: " + username + " - failed log in.");
			return "/index.jsf?faces-redirect=true";
		}
	}
	
	public String logout(){
		String username = "???";
		
		if(user != null){
			username = user.getUsername();
			user = null;
		}

		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		logger.info("Username: " + username + " - logged out.");
		return "/index.jsf?faces-redirect=true";
	}
	
	/*
	 * Expense control methods
	 */
	public void addExpense(){
		if(expenseReport != null){
			Expense newExpense = new Expense();
			newExpense.setName(expenses.getName());
			newExpense.setDate(expenses.getDate());
			newExpense.setType(expenses.getType());
			newExpense.setIssuer(expenses.getIssuer());
			newExpense.setDescription(expenses.getDescription());
			newExpense.setValue(expenses.getValue());
			newExpense.setReceipt(expenses.getReceipt());
			
			expenseReport.getExpenses().add(newExpense);
			logger.info("New Expense added to the following Expense Report: " + expenseReport.getName());
		} else {
			logger.severe("Tried to add Expense, but no Expense Report is selected.");
		}
		
		expense = null;
	}
	
	public void editExpense(){
		/* Values are edited in-place */
		expense = null;
	}
	
	public void deleteExpense(){
		List<Expense> expenseList = expenseReport.getExpenses();
		for(int i=0; i < expenseList.size(); i++){
			Expense expenseAux = expenseList.get(i);
			if(	expenseAux.getName().equals(expense.getName()) &&
				expenseAux.getType().equals(expense.getType()) &&
				expenseAux.getIssuer().equals(expense.getIssuer()) &&
				expenseAux.getValue().equals(expense.getValue())){
				expenseList.remove(i);
			}
		}
		
		expense = null;
	}
	
	public void clearExpense(){
		expense = null;
	}
	
	/*
	 * Report control methods
	 */
	
	public void addExpenseReport(){
		ExpenseReport newExpenseReport = new ExpenseReport();
		newExpenseReport.setId(Integer.toString(new Random().nextInt()));
		newExpenseReport.setName(reports.getName());
		newExpenseReport.setDescription(reports.getDescription());
		newExpenseReport.setState("NOT SUBMITTED");
		newExpenseReport.setExpenses(new ArrayList<>());
		user.getExpenseReports().add(newExpenseReport);
		logger.info("User " + user.getUsername() + " added a new Expense Report: " + newExpenseReport.getName());
		
		expenseReport = null;
	}
	
	public void editExpenseReport(){
		/* Values are edited in-place */
		expenseReport = null;
	}
	
	public void deleteExpenseReport(){
		List<ExpenseReport> expenseReportList = user.getExpenseReports();
		for(int i=0; i < expenseReportList.size(); i++){
			ExpenseReport expenseReportAux = expenseReportList.get(i);
			if(expenseReportAux.getId().equals(expenseReport.getId())){
				expenseReportList.remove(i);
			}
		}
		
		expenseReport = null;
	}
	
	public void clearExpenseReport(){
		expenseReport = null;
	}
	
	/*
	 * Approvals control methods
	 */
}