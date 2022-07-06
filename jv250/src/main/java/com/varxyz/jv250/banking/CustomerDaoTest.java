package com.varxyz.jv250.banking;

import java.util.List;

public class CustomerDaoTest {
	public static void main(String[] args) {
		CustomerDao dao = new CustomerDao();
		
		//findAllCustomers() Test
		List<Customer> customerList = dao.findAllCustomers();
		for(Customer customer : customerList) {
			System.out.println(customer);
		}
		System.out.println("----------------------------------------");
		
		//findCustomerBySsn
		Customer customer = dao.findCustomerBySsn("961578-1523267");
		System.out.println(customer);
		System.out.println("----------------------------------------");
		
		//addCustomer
		Customer c = new Customer();
		c.setName("공명");
		c.setSsn("970824-1234567");
		c.setPhone("010-5656-7878");
		c.setCustomerID("spring");
		c.setPassword("1111");
		
		dao.addCustomer(c);
		
	}
}
