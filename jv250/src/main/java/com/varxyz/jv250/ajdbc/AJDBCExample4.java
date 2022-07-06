package com.varxyz.jv250.ajdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AJDBCExample4 {
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
			
			String sql = "DELETE FROM Account WHERE cid=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, 3003);
			stmt.executeUpdate();
			
			System.out.println("DELETED...");
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
