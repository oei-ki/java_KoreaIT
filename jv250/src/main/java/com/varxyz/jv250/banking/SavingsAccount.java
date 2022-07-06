package com.varxyz.jv250.banking;

public class SavingsAccount extends Account{
	private static final double DEFAULT_INTEREST_RATE = 0.03;
	private double interestRate;	// 은행 이자율
	
	public SavingsAccount() {
		
	}
	
	public SavingsAccount(String accountNum, double balance) {
		this(accountNum, balance, DEFAULT_INTEREST_RATE);
	}
	
	public SavingsAccount(String accountNum, double balance, double interestRate) {
		super(accountNum, balance);
		this.interestRate = interestRate;
	}
	
	public void withdraw(double amount) {
		if (super.balance - amount < 0) {
			// 현재 잔고보다 많은 금액을 출금할시 예외 발생
			throw new InsufficientBalanceException("잔고부족");
		}
		// 현재 잔고보다 작다면 출금 승인
		super.balance -= amount;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
}
