package com.varxyz.banking.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.banking.cutomer.Customer;
import com.varxyz.banking.cutomer.CustomerDao;

@Controller
public class loginController {

	@Autowired
	CustomerDao customerDao;
	
	@GetMapping("/banking/login")
	public String loginForm() {
		return "banking/login";
	}
	
	@PostMapping("/banking/login")
	public String login( HttpServletRequest request) {
		String userId = request.getParameter("userId");
		String passwd = request.getParameter("passwd");
		
		if(!customerDao.isUser(userId, passwd)) {
			request.setAttribute("msg", "아이디 혹은 비밀번호가 틀렸습니다.");
			request.setAttribute("url", "banking/login");
			return "alert";
		}
		
		HttpSession session = request.getSession();
		Customer customer = customerDao.getCustomer(userId);
		session.setAttribute("customer", customer);
		session.setAttribute("userId", userId);
		
		return "banking/main";
	}
}
