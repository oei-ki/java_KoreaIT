package com.varxyz.banking.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.banking.account.Account;
import com.varxyz.banking.account.AccountDao;
import com.varxyz.banking.account.AccountServiceImpl;
import com.varxyz.banking.account.CheckingAccount;
import com.varxyz.banking.account.SavingAccount;
import com.varxyz.banking.cutomer.Customer;
import com.varxyz.banking.cutomer.CustomerServiceImpl;



@Controller
public class AddAccountController {
	
	@Autowired
	AccountDao accountDao;
	
	@Autowired
	AccountServiceImpl accountService;
	
	@Autowired
	CustomerServiceImpl customerService;
	
	
	@GetMapping("/banking/addaccount")
	public String addAccountForm() {
		return "banking/addaccount";
	}
	
	@GetMapping("/banking/success_addaccount")
	public String findAccountForm(HttpServletRequest request) {
		HttpSession session = request.getSession();		
		String userId = (String)session.getAttribute("userId");
			
		
		List<Account> accountList = accountService.getAccounts(userId);
		System.out.println(userId);
		request.setAttribute("accountList", accountList);
		return "banking/success_addaccount";
	}
	
	@PostMapping("/banking/addaccount")
	public String addAccount(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		String userId = (String)session.getAttribute("userId");
		char accType = request.getParameter("accType").charAt(0);
		Account account = null;
		
		if(accType == 'S') {
			account = new SavingAccount();
		}else if (accType == 'C') {
			account = new CheckingAccount();
		}
		
		account.setAccountNum(generateAccount());
		account.setCustomer(customerService.getCustomer(userId));
		System.out.println(account);
		account.setAccType(accType);
		accountService.addAccounts(account);
		request.setAttribute("accType", account.getAccountNum());
		
		session.setAttribute("account", account);
		
		return "banking/success_addaccount";
	}
	
//	public String addAccount(HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		String userId = (String)session.getAttribute("userId");
//		char accType = request.getParameter("accType").charAt(0);
//		Account account = null;
//		
//		if(accType == 'S') {
//			account = new SavingAccount();
//		}else if (accType == 'C') {
//			account = new CheckingAccount();
//		}
//		
//		account.setAccountNum(generateAccount());
//		account.setCustomer(customerService.getCustomerByUserId(userId));
//		account.setAccType(accType);
//		accountService.addAccounts(account);
//		request.setAttribute("accType", account.getAccountNum());
//		return "account/add_success_account";
//			
//	}
//	
	
	/**
	 * XXX-XX-XXXX 형식의 계좌번호 생성.
	 * 
	 * @return
	 */
	public String generateAccount() {
		String numStr = String.valueOf((int)(Math.random() * 100000000));
		StringBuilder sb = new StringBuilder();
		sb.append(numStr.substring(0, 3));
		sb.append("-");
		sb.append(numStr.substring(3, 5));
		sb.append("-");
		sb.append(numStr.substring(5));
		
		return sb.toString();
	}

}
