package com.varxyz.jv250.ajdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AJDBCExample {
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
			
			String sql = "SELECT * FROM Account WHERE aid=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, 3003);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				long aid = rs.getLong("aid");
				String accountNum = rs.getString("accountNum");
				double balance = rs.getDouble("balance");
				double interestRate = rs.getDouble("interestRate");
				double overdraft = rs.getDouble("overdraft");
				String accountType = rs.getString("accountType");
				long customerId = rs.getLong("customerId");
				
				System.out.println(aid);
				System.out.println(accountNum);
				System.out.println(balance);
				System.out.println(interestRate);
				System.out.println(overdraft);
				System.out.println(accountType);
				System.out.println(customerId);
			}
			rs.close();
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
