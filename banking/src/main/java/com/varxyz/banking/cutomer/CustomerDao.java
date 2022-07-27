package com.varxyz.banking.cutomer;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.varxyz.banking.account.Account;

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
	
	public Customer getCustomer(String userId) {
		String sql = "SELECT cid, userId, passwd, name, ssn, phone, regDate FROM Customer1 WHERE userId=?";
		return jdbcTemplate.queryForObject(sql, new CustomerRowMapper(), userId);
	}
	
	public boolean isUser(String userId, String passwd) {
		String sql = "SELECT count(*) FROM Customer1 WHERE userId=? AND passwd=?";
		boolean result = true;
		int ishere = jdbcTemplate.queryForObject(sql, Integer.class, userId, passwd);
		if(ishere == 0 ) {
			result = false; 
		}
		return result;
		
	}
}
