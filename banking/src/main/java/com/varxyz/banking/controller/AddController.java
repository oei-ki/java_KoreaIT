
package com.varxyz.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.banking.DataSourceConfig;
import com.varxyz.banking.customer.Customer;
import com.varxyz.banking.customer.CustomerCommand;
import com.varxyz.banking.customer.CustomerServiceImpl;

@Controller("customer.addController")
public class AddController {
	
	@Autowired
	CustomerServiceImpl customerService;
	
	
	@GetMapping("/banking/addCustomer")
	public String addCustomerForm() {
		return "banking/addCustomer";
	}
	
	@PostMapping("/banking/addCustomer")
	public String addCustomer(CustomerCommand customerCommand, Model model) {
//		model.addAttribute("customer", customer);
//		
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
//		CustomerDao dao = context.getBean("customerDao", CustomerDao.class);
//		dao.addCustomer(customer);
//		
//		context.close();
//		
		model.addAttribute("customerCommand", customerCommand);	
		Customer customer = new Customer();
		customer.setCid(customerCommand.getCid());
		customer.setUserId(customerCommand.getUserId());
		customer.setPasswd(customerCommand.getPasswd());
		customer.setName(customerCommand.getName());
		customer.setSsn(customerCommand.getSsn());
		customer.setPhone(customerCommand.getPhone());
		customerService.addCustomer(customer);

		return "banking/success_addCustomer";
	}
}
