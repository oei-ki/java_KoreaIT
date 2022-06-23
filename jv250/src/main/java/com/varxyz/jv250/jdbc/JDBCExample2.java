package com.varxyz.jv250.jdbc;

import java.sql.*;  /*static method????*/

public class JDBCExample2 {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jv250?severTimezone=Asia/Seoul";
		String id = "jv250";
		String passwd = "jv250";
		/*자바스타일 이 방식을 더 이용함*/
		
		try {
			Class.forName(driver);
			System.out.println("LOADED DRIVER ------>" + driver);
			
			
			Connection con = DriverManager.getConnection(url, id, passwd);
			System.out.println("CONNECTED TO ------->" + url);
			
			String sql = "SELECT * FROM Customer WHERE name = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,"유비");  
			ResultSet rs = stmt.executeQuery();
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
			/*실행 한 것과 반대로 닫는다.*/
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
