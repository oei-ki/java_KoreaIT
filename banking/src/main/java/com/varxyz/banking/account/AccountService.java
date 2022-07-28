package com.varxyz.banking.account;

import java.util.List;

public interface AccountService {
	
	void addAccounts(Account account);
	List<Account> getAccounts(String userId);
	long getBalance(String accountNum);
	void transfer(double money, String withdrawAccountNum, String depositAccountNum);
//	void saveInterest(String accountNum, double interestRate);
}
