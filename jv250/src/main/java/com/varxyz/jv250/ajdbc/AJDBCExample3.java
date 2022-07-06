package com.varxyz.jv250.ajdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AJDBCExample3 {
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
			
			String sql = "UPDATE Account SET accountNum=?, balance=?, overdraft=? WHERE aid=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "929-12-5334");
			stmt.setDouble(2, 70000.0);
			stmt.setDouble(3, 28000.0);
			stmt.setLong(4, 3003);
			stmt.executeUpdate();
			
			System.out.println("UPDATED...");
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
