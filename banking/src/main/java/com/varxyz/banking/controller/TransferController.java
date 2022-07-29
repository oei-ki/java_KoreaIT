package com.varxyz.banking.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.banking.account.Account;
import com.varxyz.banking.account.AccountServiceImpl;
import com.varxyz.banking.customer.Customer;
import com.varxyz.banking.customer.CustomerServiceImpl;

@Controller
public class TransferController {
	
	@Autowired
	AccountServiceImpl accountService;
	
	@Autowired
	CustomerServiceImpl customerService;

	@GetMapping("/banking/deposit")
	public String depositForm(HttpServletRequest request) {
		HttpSession session = request.getSession();		
		String userId = (String)session.getAttribute("userId");
		List<Account> accountList = accountService.getAccounts(userId);
		request.setAttribute("accountList", accountList);
		return "banking/deposit"; 
	}
	
	@PostMapping("/banking/deposit")
	public String deposit(HttpServletRequest request) {

		
		String accountNum = (String)request.getParameter("accountNum");
		double money = Double.parseDouble(request.getParameter("money"));
		request.setAttribute("accountNum", accountNum);
		request.setAttribute("money", money);
		accountService.deposit(money, accountNum);
		
		return "banking/main"; 
	}
	
	
	@GetMapping("/banking/transfer")
	public String transferForm(HttpServletRequest request) {
		HttpSession session = request.getSession();		
		String userId = (String)session.getAttribute("userId");
			
		List<Account> accountList = accountService.getAccounts(userId);
		System.out.println(userId);
		request.setAttribute("accountList", accountList);
		return "banking/transfer"; 
	}
	
	@PostMapping("/banking/transfer")
	public String transfer(HttpServletRequest request,HttpSession session) {
		String withdrawAccountNum = request.getParameter("withdrawAccountNum");
		double sendMoney = Double.parseDouble(request.getParameter("sendMoney"));
		String depositAccountNum = request.getParameter("depositAccountNum");
		Customer customer = customerService.getCustomerByAccountNum(depositAccountNum);
		if(customer == null) {
			request.setAttribute("msg", "계좌번호를 잘못 입력하셨습니다. 확인해 주세요");
			request.setAttribute("url", "transfer");
			return "banking/main";
		}
		
		
		session = request.getSession();
		session.setAttribute("withdrawAccountNum", withdrawAccountNum);
		session.setAttribute("depositAccountNum", depositAccountNum);
		session.setAttribute("sendMoney", sendMoney);
		System.out.println(sendMoney);
		System.out.println(withdrawAccountNum);
		System.out.println(depositAccountNum);
		
		double withdrawBalance = accountService.getBalance(withdrawAccountNum);

		
		if(withdrawBalance - sendMoney < 0) {
			request.setAttribute("msg", "잔액이 부족합니다.");
			request.setAttribute("url", "transfer");
			return "banking/main";
		}

		accountService.transfer(sendMoney, withdrawAccountNum, depositAccountNum);
		request.setAttribute("msg", "송금이 완료되었습니다.");
		request.setAttribute("url", "/banking/main");
		session.removeAttribute("withdrawAccountNum");
		session.removeAttribute("receiveName");
		session.removeAttribute("depositAccountNum");
		session.removeAttribute("passwd");
		session.removeAttribute("sendMoney");
		
		return "banking/success_transfer";
		
	}
	
//	@PostMapping("/banking/transfer_success")
//	public String transferSuccess(HttpSession session, HttpServletRequest request) {
//		String withdrawAccountNum = (String)session.getAttribute("withdrawAccountNum");
//		double sendMoney = (double)session.getAttribute("sendMoney");
//		String depositAccountNum = (String)session.getAttribute("depositAccountNum");
//		double withdrawBalance = accountService.getBalance(withdrawAccountNum);
//		String checkPasswd = (String)session.getAttribute("passwd");
//		String passwd = request.getParameter("passwd");
//		
//		if(withdrawBalance - sendMoney < 0) {
//			request.setAttribute("msg", "잔액이 부족합니다.");
//			request.setAttribute("url", "transfer");
//			return "alert";
//		}
//		if(!checkPasswd.equals(passwd)) {
//			request.setAttribute("msg", "비밀번호가 틀렸습니다.");
//			request.setAttribute("url", "transfer");
//			return "alert";
//		}
//
//		accountService.transfer(sendMoney, withdrawAccountNum, depositAccountNum);
//		request.setAttribute("msg", "송금이 완료되었습니다.");
//		request.setAttribute("url", "/banking/main");
//		session.removeAttribute("withdrawAccountNum");
//		session.removeAttribute("receiveName");
//		session.removeAttribute("depositAccountNum");
//		session.removeAttribute("passwd");
//		session.removeAttribute("sendMoney");
//		return "banking/success_tranfer";
//	}
}
