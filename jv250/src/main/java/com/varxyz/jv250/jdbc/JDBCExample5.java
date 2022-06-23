package com.varxyz.jv250.jdbc;

import java.sql.Connection;  /*static method????*/
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*삭제*/
public class JDBCExample5 {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jv250?severTimezone=Asia/Seoul";
		String id = "jv250";
		String passwd = "jv250";
		Connection con = null;
		PreparedStatement stmt = null;
		/*기존값 수정*/
		try { 
			try {				
				Class.forName(driver); /*드라이버 접근*/
				System.out.println("LOADED DRIVER ------>" + driver);
				
				
				con = DriverManager.getConnection(url, id, passwd);
				System.out.println("CONNECTED TO ------->" + url);
				
				String sql = "DELETE FROM Customer WHERE cid =?"; /*?로 값을 그때마다 받는다 동적으로 처리*/
				stmt = con.prepareStatement(sql);
				stmt.setLong(1,1001);
				stmt.executeUpdate();
				
				System.out.println("DELETE.........");
			}finally {
				stmt.close();
				con.close();

			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		/*catch (SQLException e) {   두개 사용하기 싫으면 위 처럼 부모클래스(Exception) 사용
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}*/
		
	}
}
