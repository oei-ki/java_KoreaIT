package com.varxyz.banking.service;

import java.util.*;

import com.varxyz.banking.domain.Account;


public interface AccountService {
	void addAccount(Account account);//신규 고객추가
	void addAccount(Account account, String ssn);
	List<Account> getAccountBySsn(String ssn); //전체 고객목록
	Account getAccountByAccountNum(String accountNum);
	Collection<Account> getAllAccounts();  //Map, List 를 받으려고 Collection으로 처리
	int getNumOfAccounts(); //전체 고객 수
}
