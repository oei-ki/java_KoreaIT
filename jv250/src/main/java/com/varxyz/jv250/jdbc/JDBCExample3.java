package com.varxyz.jv250.jdbc;

import java.sql.Connection;  /*static method????*/
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample3 {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jv250?severTimezone=Asia/Seoul";
		String id = "jv250";
		String passwd = "jv250";
		/*새로운 값 업데이트*/
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			Class.forName(driver);
			System.out.println("LOADED DRIVER ------>" + driver);
			
			
			con = DriverManager.getConnection(url, id, passwd);
			System.out.println("CONNECTED TO ------->" + url);
			
			String sql = "INSERT INTO Customer(name, ssm, phone, customerId, passwd)"
			+ " VALUES (?, ?, ?, ?, ?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1,"조조");  /*자바스타일 이 방식을 더 이용함*/
			stmt.setString(2,"840824-1234567");
			stmt.setString(3,"010-2454-5480");
			stmt.setString(4,"sql");
			stmt.setString(5,"1111");
			stmt.executeUpdate();

			System.out.println("INSERTED.........");
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			if( stmt != null) try{stmt.close();}catch(Exception e){}
			if( con != null) try{con.close();}catch(Exception e){}
		}
		
	}
}
