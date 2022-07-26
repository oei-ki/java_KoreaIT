package com.varxyz.banking.cutomer;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class CustomerDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public CustomerDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void addCustomer(Customer customer) {
		String sql = "INSERT INTO Customer1 (userId, passwd, name, ssn, phone) "
				+ "VALUES (?,?,?,?,?)";
		jdbcTemplate.update(sql, customer.getUserId(), customer.getPasswd(),
				customer.getName(), customer.getSsn(), customer.getPhone());
	}
}
