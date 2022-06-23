package com.varxyz.jv250.jdbc;

import java.sql.Connection;  /*static method????*/
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*기본방식*/
public class JDBCExample {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jv250?severTimezone=Asia/Seoul";
		String id = "jv250";
		String passwd = "jv250";
		
		
		try {
			Class.forName(driver);
			System.out.println("LOADED DRIVER ------>" + driver);
			
			
			Connection con = DriverManager.getConnection(url, id, passwd);
			System.out.println("CONNECTED TO ------->" + url);
			
			String sql = "SELECT * FROM Customer WHERE name='유비'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {  /*다음칸으로 넘어가면서 true와 false를 구별함*/
				long cid = rs.getLong("cid");
				String customerId = rs.getString("customerId");
				String name = rs.getString("name");
				String phone  = rs.getString("phone");
				System.out.println(cid);
				System.out.println(customerId);
				System.out.println(name);
				System.out.println(phone);
				System.out.println("---------------------------------");
			} 
			
			/*데이터를 다 사용 했으면 열었던 드라이버를 닫아야 함. 실행 한 것과 반대로 닫는다.*/
			rs.close();
			stmt.close();
			con.close();
			
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
