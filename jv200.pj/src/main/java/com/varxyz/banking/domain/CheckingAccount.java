package com.varxyz.banking.domain;

public class CheckingAccount extends Account{
	private double overdraftAmount;
	
	public CheckingAccount(String accountNum, double balance, double overdraftAmount) {
		super(accountNum, balance);
		this.overdraftAmount = overdraftAmount;
	}
	
	public void withdraw(double amount) {

		try {
			if(balance < amount) {
				//잔고 부족시 overdraftAmount 금액 한도 내에서 추가 출금을 승인
				throw new InsufficientBalanceException("한도 초과");
				//한도액을 정하자,,
			}else {
				balance = balance - amount;
			}
		}catch (InsufficientBalanceException ex) {//한도초과액로 마이너스통장식으로 구현 마이너스 통장한도 생성?
			if(balance < amount) {
				
			}
		}

	}
}
