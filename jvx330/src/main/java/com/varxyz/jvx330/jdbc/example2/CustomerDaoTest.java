package com.varxyz.jvx330.jdbc.example2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.jvx330.jdbc.Customer;
import com.varxyz.jvx330.jdbc.DataSourceConfig;
import com.varxyz.jvx330.jdbc.example1.AddCustomerDao;

public class CustomerDaoTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		
		CustomerDao dao = context.getBean("customerDao", CustomerDao.class);
		findAllCustomers(dao);
		findCustomerByRegDate(dao);
		findCustomerByEmail(dao);
		countCustomers(dao);
		
		context.close();
	}
	
	public static void findAllCustomers(CustomerDao dao) {
		System.out.println("[findAllCustomers()]");
		dao.findAllCustomers().forEach(c -> System.out.println(c));
		
	}
	
	public static void findCustomerByRegDate(CustomerDao dao) {
		System.out.println("[findCustomerByRegDate()]");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = null;
		try {
			currentDate = format.parse(format.format(new Date()));	//new Date여기서 오늘 날짜로 검색한거임
//			currentDate = format.parse("2022-07-22");	//new Date여기서 오늘 날짜로 검색한거임
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<Customer> list = dao.findCustomerByRegDate(currentDate);
		for(Customer customer : list) {
			System.out.println(customer);
		}
		
//		Date date = Date.valueOf("2022-07-22");
//		System.out.println(dao.findCustomerByRegDate(date));
	}
	
	public static void findCustomerByEmail(CustomerDao dao) {
		System.out.println("[findCustomerByEmail()]");
		System.out.println(dao.findCustomerByEmail("jangbi@java.com"));
	}
	
	public static void countCustomers(CustomerDao dao) {
		System.out.println("[countCustomers()]");
		System.out.println("count : " + dao.countCustomers());
	}

}
