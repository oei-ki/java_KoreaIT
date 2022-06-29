package com.varxyz.jv251.dao;

import java.sql.*;
import java.util.*;

import com.varxyz.jv251.domain.Customer;

public class CustomerDao {


	/**
	 * 전체 고객 정보 조히
	 * @return
	 */
	public List<Customer> findAllCustomers(){
		String sql = "SELECT * FROM Customer";
		List<Customer> customerList = new ArrayList<>();
		
		 try {
			 Connection con = null;
			 PreparedStatement pstmt = null;
			 ResultSet rs = null;
			try {
				con = DataSourceManager.getConnection();  //DriverManager.getConnection 코드를 바꿔도 상관없다?? DataSourceManager메소드에서 연결시키기 때문에?
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Customer c = new Customer();
					c.setCid(rs.getLong("cid"));
					c.setName(rs.getString("name"));
					c.setSsn(rs.getString("ssm"));
					c.setPhone(rs.getString("phone"));
					c.setUserId(rs.getString("userId"));
					customerList.add(c);
					}
				} finally {
					DataSourceManager.close(rs,pstmt,con);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerList;
	}
	
	/** 즉시로딩으로 처리할지..
	 * 주민번호로 고객 조회 //account없이 customer 정보만 가져옴//조인으로 account를 같이 가져올 수 있음.
	 * @param ssn
	 */
	public Customer findCustomerBySsn(String ssn) { //주민번호로 고객조회하는 메소드
		String sql = "SELECT * FROM Customer WHERE ssm = ?";
		Customer c = null;
		try {
			 Connection con = null;
			 PreparedStatement pstmt = null;
			 ResultSet rs = null;
			 try {
				 con = DataSourceManager.getConnection();
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, ssn); //위 where?로 조회하는거임
					rs = pstmt.executeQuery();  /*rs 객체의 값을 반환 , SELECT 구문을 수행*/
					if(rs.next()) { //조회한 값 한번 나오게 하는거 
						c = new Customer(); //여기서 객체 생성
						c.setCid(rs.getLong("cid"));
						c.setName(rs.getString("name"));
						c.setSsn(rs.getString("ssm"));
						c.setPhone(rs.getString("phone"));
						c.setUserId(rs.getString("userId"));
					}
			} finally {
				DataSourceManager.close(rs,pstmt,con);	
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
		String sql = "INSERT INTO Customer(name, ssm, phone,userId, passwd)" + " VALUES (?,?,?,?,?)";
		
		try {
			Connection con = DataSourceManager.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, customer.getName());
			pstmt.setString(2, customer.getSsn());
			pstmt.setString(3, customer.getPhone());
			pstmt.setString(4, customer.getUserId());
			pstmt.setString(5, customer.getPasswd());
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
			System.out.println("INSERTED................");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
}
