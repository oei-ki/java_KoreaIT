package com.varxyz.jv251.service;

import java.util.*;

import com.varxyz.jv251.dao.AccountDao;
import com.varxyz.jv251.domain.Account;

public class AccountService {
	private AccountDao accountDao;
	
	public AccountService(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
	public void addAccount(Account account) {
		accountDao.addAccount(account);	
	}
	
	public List<Account> getAccountsBySsn(String ssn) {
		return accountDao.findAccountsBySsn(ssn);
	}
	
	public static void main(String[] args) {
		AccountService service = new AccountService(null);
		System.out.println(service.generateAccountNum());
	}
	
	public Account getaccountCheck(String accountNum) {
		return accountDao.accountCheck(accountNum);
	}
	
	public void getupdateAccount(Account account) {
		accountDao.updateAccount(account);
	}
	
	/**
	 * xxx-xx-xxxx
	 * @return
	 */
	public String generateAccountNum() {
		String numStr = String.valueOf((int)(Math.random() * 100000000));
		StringBuilder sb = new StringBuilder();
		sb.append(numStr.substring(0,3));
		sb.append("-");
		sb.append(numStr.substring(3,5));
		sb.append("-");
		sb.append(numStr.substring(5));
		
		return sb.toString();
	}	
}
//	public Account findAllAccountsBySsn(String ssn) {
//		return accountDao.findAllAccountsBySsn(ssn);
//	}
	
