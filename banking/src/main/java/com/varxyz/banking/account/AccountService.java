package com.varxyz.banking.account;

import java.util.List;

import com.varxyz.banking.customer.Customer;

public interface AccountService {
	
	void addAccounts(Account account);
	List<Account> getAccounts(String userId);
	long getBalance(String accountNum);
	void transfer(double money, String withdrawAccountNum, String depositAccountNum);
//	void saveInterest(String accountNum, double interestRate);
	void deposit(double money, String accountNum);
	
	
	
}
