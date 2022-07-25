package com.varxyz.jvx330.jdbc.example2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.varxyz.jvx330.jdbc.Customer;

public class CustomerDao {
	private JdbcTemplate jdbcTemplate;
	
	public CustomerDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Customer> findAllCustomers() {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate FROM Customer";
		
		return jdbcTemplate.query(sql, new RowMapper<Customer>() { //RowMapper로 Customer를 감싸도록?

			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer customer = new Customer(rs.getLong("cid"),rs.getString("email"),
						rs.getString("name"),rs.getString("passwd"),rs.getString("ssn"),
						rs.getString("phone"),rs.getTimestamp("regDate"));
				return customer;  //for문 처럼 만들었다는데...
			}
		});
	}
	
	public List<Customer> findCustomerByRegDate(Date regDate) {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate "
				+ "FROM Customer WHERE DATE(regDate)=?"; 
		//DATE날짜만 
		return jdbcTemplate.query(sql, new RowMapper<Customer>() {

			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer customer = new Customer(rs.getLong("cid"),rs.getString("email"),
						rs.getString("name"),rs.getString("passwd"),rs.getString("ssn"),
						rs.getString("phone"),rs.getTimestamp("regDate"));
				return customer;  //int rowNum 큰 영향없는듯 신경쓰지 마
			}
		}, regDate); //regDate 조건준거임 그래서 아규먼트에 들어가서 값 가져온거
	}
	
	public Customer findCustomerByEmail(String email) {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate "
				+ "FROM Customer WHERE email=?"; 
		
		return jdbcTemplate.queryForObject(sql, new RowMapper<Customer>() {
				//queryForObject는 하나의 결과값만 필요할때
			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer customer = new Customer(rs.getLong("cid"),rs.getString("email"),
						rs.getString("passwd"),rs.getString("name"),rs.getString("ssn"),
						rs.getString("phone"),rs.getTimestamp("regDate"));
				return customer; 
			}
		}, email); //email 조건준거임 그래서 아규먼트에 들어가서 값 가져온거
	}
	
	public long countCustomers() {
		String sql = "SELECT count(*) FROM Customer";
		return jdbcTemplate.queryForObject(sql, Long.class);
	}
}
