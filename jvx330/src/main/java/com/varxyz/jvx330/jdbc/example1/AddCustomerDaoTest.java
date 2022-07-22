package com.varxyz.jvx330.jdbc.example1;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.jvx330.jdbc.Customer;
import com.varxyz.jvx330.jdbc.DataSourceConfig;

public class AddCustomerDaoTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		AddCustomerDao dao = context.getBean("addCustomerDao", AddCustomerDao.class);
		addCustomer(dao);
		addCustomer2(dao);
		addCustomer3(dao);
		
		context.close();

	}
	
	public static void addCustomer(AddCustomerDao dao) {
		Customer c = new Customer();
		c.setEmail("Kwanwu@java.com");
		c.setPasswd("1111");
		c.setName("관우");
		c.setSsn("800222-1234567");
		c.setPhone("010-6623-2285");
		
		dao.addCustomer(c);
		System.out.println("-inserted-");
	}
	
	public static void addCustomer2(AddCustomerDao dao) {
		Customer c = new Customer();
		c.setEmail("jangbi@java.com");
		c.setPasswd("1111");
		c.setName("장비");
		c.setSsn("900331-1234567");
		c.setPhone("010-9988-2285");
		
		dao.addCustomer(c);
		System.out.println("-inserted-");
	}
	
	public static void addCustomer3(AddCustomerDao dao) {
		Customer c = new Customer();
		c.setEmail("chocho@java.com");
		c.setPasswd("1111");
		c.setName("조조");
		c.setSsn("700425-1234567");
		c.setPhone("010-4455-2285");
		
		long key = dao.addCustomer3(c);
		System.out.println("-key-" + key);
	}
}
