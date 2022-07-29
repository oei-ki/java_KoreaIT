package com.varxyz.banking.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.varxyz.banking.account.Account;
import com.varxyz.banking.account.AccountDao;
import com.varxyz.banking.account.AccountServiceImpl;
import com.varxyz.banking.customer.Customer;
import com.varxyz.banking.customer.CustomerDao;
import com.varxyz.banking.customer.CustomerServiceImpl;

public class TransferAccount implements BankService {
	
	@Autowired
	AccountDao accountDao;
	
	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	BankService bankService;
	
   @Override
   @Transactional
   public boolean transfer(double money, String withdrawAccountNum, String depositAccountNum) {
	   
	   try {
		   accountDao.deposit(money, depositAccountNum);
		   accountDao.withdraw(money, withdrawAccountNum);
		   
		   double withdrawBalance = bankService.getBalance(withdrawAccountNum);
			if(withdrawBalance - money < 0) {
				return false;
			}
	} catch (Exception e) {
		return false;		
	}
	   return true;
   }
 }
