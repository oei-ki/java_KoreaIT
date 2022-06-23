package com.varxyz.jv250.bangking;

import java.util.*;

public class Account {
	protected long aid;
	protected String accountNum;
	protected double balance;
	protected Customer customer;
	protected char accountType;
	protected long customerId;
	protected Date regDate;


	public Account() {
	}
	
	public Account(String accountNum, double balance) {
		this.accountNum = accountNum;
		this.balance = balance;
	}

	public Date getRegDate() {
		return regDate;
	}
	
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public long getAid() {
		return aid;
	}
	
	
	public void setAid(long aid) {
		this.aid = aid;
	}

	public long getCustomerId() {
		return customerId;
	}


	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}


	public char getAccountType() {
		return accountType;
	}


	public void setAccountType(char accountType) {
		this.accountType = accountType;
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
	public String toString() { //간결하면서 사람이 읽기 쉬운 형태의 유익한 정보를 반환
		
		return "고객정보 = "+ getAid() +"," + getAccountNum() + "," + getBalance()  + "," + getAccountType() + getCustomerId()
		+ getCustomer();
	}  //출력 형태임 따로 사용메소드 안걸어도 됨?
}
