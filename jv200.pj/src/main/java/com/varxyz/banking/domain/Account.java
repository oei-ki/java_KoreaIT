package com.varxyz.banking.domain;
/**
 * --... ----- 
 * @author Administrator
 *
 */
public class Account {
	protected String accountNum;
	protected double balance;
	protected Customer customer;
	
	public Account(String accountNum, double balance) {
		this.accountNum = accountNum;
		this.balance = balance;
	}
	
	
	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public void deposite(double amount) { //입금액
		this.balance += amount; 
	}
	//계좌 만들어야하니까 생성틀 만들기
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
