package com.varxyz.banking.cutomer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.banking.DataSourceConfig;

@Controller("banking.addController")
public class AddController {
	
	
	@GetMapping("/banking/addCustomer")
	public String addCustomerForm() {
		return "banking/addCustomer";
	}
	
	@PostMapping("/banking/addCustomer")
	public String addCustomer(Customer customer, Model model) {
		model.addAttribute("customer", customer);
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		CustomerDao dao = context.getBean("customerDao", CustomerDao.class);
		dao.addCustomer(customer);
		
		context.close();
		
		return "banking/success_addCustomer";
		
		
	}
}
