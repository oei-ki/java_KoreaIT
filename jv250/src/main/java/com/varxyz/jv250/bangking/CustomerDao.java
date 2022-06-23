package com.varxyz.jv250.bangking;

import java.sql.*;
import java.util.*;

public class CustomerDao {
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/jv250?severTimezone=Asia/Seoul";
	private static final String JDBC_USER = "jv250";
	private static final String JDBC_PASSWORD = "jv250";
	
	public CustomerDao() {
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("LOADED DRIVER ------>" + JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public List<Customer> findAllCustomers(){
		String sql = "SELECT * FROM Customer";
		List<Customer> customerList = new ArrayList<>();
		
		 try {
			 Connection con = null;
			 PreparedStatement pstmt = null;
			 ResultSet rs = null;
			try {
				con = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Customer c = new Customer();
					c.setCid(rs.getLong("cid"));
					c.setName(rs.getString("name"));
					c.setSsn(rs.getString("ssm"));
					c.setPhone(rs.getString("phone"));
					c.setCustomerId(rs.getString("customerId"));
					customerList.add(c);
					}
				} finally {
					rs.close();
					pstmt.close();
					con.close();	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerList;
	}
	
	/**
	 * 주민번호로 고객 조회
	 * @param ssn
	 */
	public Customer findCustomerBySsn(String ssm) { //주민번호로 고객조회하는 메소드
		String sql = "SELECT * FROM Customer WHERE ssm = ?";
		Customer c = null;
		try {
			 Connection con = null;
			 PreparedStatement pstmt = null;
			 ResultSet rs = null;
			 try {
					con = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, ssm); //위 where?로 조회하는거임
					rs = pstmt.executeQuery();  /*rs 객체의 값을 반환 , SELECT 구문을 수행*/
					if(rs.next()) { //조회한 값 한번 나오게 하는거 
						c = new Customer(); //여기서 객체 생성
						c.setCid(rs.getLong("cid"));
						c.setName(rs.getString("name"));
						c.setSsn(rs.getString("ssm"));
						c.setPhone(rs.getString("phone"));
						c.setCustomerId(rs.getString("customerId"));
					}
			} finally {
				rs.close();
				pstmt.close();
				con.close();	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	/**
	 * 신규 고객 등록
	 * @param customer    등록할 고객정보
	 */
	public void addCustomer(Customer customer) {
		String sql = "INSERT INTO Customer(name.ssn.phoen, customerId, passwd)" + "VALUES (?,?,?,?,?)";
		
		try {
			Connection con = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, customer.getName());
			pstmt.setString(2, customer.getSsn());
			pstmt.setString(3, customer.getPhone());
			pstmt.setString(4, customer.getCustomerId());
			pstmt.setString(5, customer.getPasswd());
			pstmt.close();
			con.close();
			System.out.println("INSERTED................");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
}
