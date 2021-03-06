package com.varxyz.jv250.bangking;

public class SavingsAccount extends Account{
	private static final double DEFAULT_INTEREST_RATE = 0.03;
	private double interestRate;
	
	
	public SavingsAccount() {
	}
	
	public SavingsAccount(String accountNum, Double balance) {
		this(accountNum,balance,DEFAULT_INTEREST_RATE);
	}
	
	public SavingsAccount(String accountNum, Double balance, double interestRate) {
		super(accountNum,balance);
		this.interestRate = interestRate;
	}
	
	
	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public void withdraw(double amount) {
		if( balance - amount < 0 ) {
			//잔고 부족 예외발생	
			throw new InsufficientBalanceException("잔고부족");
		}	
		super.balance -= amount; 
	}

}
