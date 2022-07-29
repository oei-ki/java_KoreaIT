package com.varxyz.banking.customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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
	
	public Customer getCustomerByAccountNum(String accountNum){
		try {
		    String sql = "SELECT * FROM Customer1 c INNER JOIN Account1 a ON a.customerId = c.cid"
					+ " WHERE a.accountNum=?";
		    return jdbcTemplate.queryForObject(sql, new RowMapper<Customer>() { //하나만 찾는 메소드 queryForObject

				@Override
				public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
					Customer customer = new Customer(rs.getLong("cid"),
							rs.getString("userId"), rs.getString("passwd"), 
							rs.getString("name"), rs.getString("ssn"),
							rs.getString("phone"), rs.getTimestamp("regDate"));
					return customer;
				}
				
			}, accountNum);
		} catch (IncorrectResultSizeDataAccessException error) { // 쿼리문에 해당하는 결과가 없거나 2개 이상일 때
		    return null;
		}
	}
}
