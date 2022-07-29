package com.varxyz.banking.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.varxyz.banking.customer.Customer;


public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountDao accountDao;

	@Override
	public void addAccounts(Account account) {
		accountDao.addAccount(account);
	}

	@Override
	public List<Account> getAccounts(String userId) {
		return accountDao.getAccounts(userId);
	}

	@Override
	public long getBalance(String accountNum) {
		return accountDao.getBalance(accountNum);
	}

	@Override
	public void transfer(double money, String withdrawAccountNum, String depositAccountNum) {
		accountDao.transfer(money, withdrawAccountNum, depositAccountNum);
		
	}
//
//	@Override
//	public void saveInterest(String accountNum, double interestRate) {
//		accountDao.saveInterest(accountNum, interestRate);
//	}

	@Override
	public void deposit(double money, String accountNum) {
		accountDao.deposit(money, accountNum);
		
	}

	
}
