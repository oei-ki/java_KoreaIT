package com.varxyz.jv250.ajdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AJDBCExample2 {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jv250?serverTimezone=Asia/Seoul";
		String id = "jv250";
		String passwd = "jv250";
		
		try {
			Class.forName(driver);
			System.out.println("드라이버 로드중..." + driver);
			
			Connection con = DriverManager.getConnection(url, id, passwd);
			System.out.println("url 연결중..." + url);
			
			String sql = "INSERT INTO Account (accountNum, balance, interestRate, overdraft, accountType, customerId)"
			 + " VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "789-45-1234");
			stmt.setDouble(2, 30000.0);
			stmt.setDouble(3, 3.0);
			stmt.setDouble(4, 70000.0);
			stmt.setString(5, "S");
			stmt.setLong(6, 1008);
			stmt.executeUpdate();
			
			System.out.println("INSERTED...");
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
