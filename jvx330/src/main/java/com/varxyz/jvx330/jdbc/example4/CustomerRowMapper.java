package com.varxyz.jvx330.jdbc.example4;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.varxyz.jvx330.jdbc.Customer;

public class CustomerRowMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer(rs.getLong("cid"),
				rs.getString("email"),rs.getString("name"),rs.getString("passwd"),
				rs.getString("ssn"),rs.getString("phone"),rs.getTimestamp("regDate"));
		return customer;
	}
}
