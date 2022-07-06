package com.varxyz.jv250.banking;

public class CheckingAccount extends Account {
	protected double overdraftAmount = 10000.0;  // 대출 한도액
	
	public CheckingAccount() {
		
	}
	
	public CheckingAccount(String accountNum, double balance, double overdraftAmount) {
		super(accountNum, balance);
		this.overdraftAmount = overdraftAmount;
	}
	
	public void withdraw(double amount) {
		if (super.balance < amount) {
			// 잔고부족시 overdraftAmount 금액 한도내에서 추가 출금을 승인
			overdraftAmount -= amount;
		}else {
			// 잔고가 부족하지 않다면 현재잔고에서 출금 승인
			super.balance -= amount;
		}
	}

	public double getOverdraftAmount() {
		return overdraftAmount;
	}

	public void setOverdraftAmount(double overdraftAmount) {
		this.overdraftAmount = overdraftAmount;
	}
}
