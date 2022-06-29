package com.varxyz.jv251.domain;

import com.varxyz.jv251.exception.InsufficientBalanceException; //다른패키지랑 import 함

public class SavingsAccount extends Account{
	private double interestRate;
	
	
	public SavingsAccount() {
	}
	
	public SavingsAccount(String accountNum, Double balance) {
		this(accountNum,balance, 0.0);
	}
	
	public SavingsAccount(String accountNum, Double balance, double interestRate) {
		super(accountNum,balance);
		this.interestRate = interestRate;
	}
	
	public void withdraw(double amount) {
		if( balance - amount < 0 ) {
			//잔고 부족 예외발생	
			throw new InsufficientBalanceException("잔고부족");
		}	
		super.balance -= amount; 
	}
	
	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	

}
