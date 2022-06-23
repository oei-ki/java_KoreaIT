package com.varxyz.jv250.jdbc;

import java.util.Date;
import java.sql.*;  /*static method????*/
import java.sql.Timestamp;
/*기본방식*/
public class JDBCExample_Acouunt3 {
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
			
			String sql = "INSERT INTO Account (accountNum,balance,interertRete,overdraft,accountType,customerId)"
			+"VALUES(?,?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql); /*PreparedStatement - Statement 클래스의 기능 향상 -> 코드량이 증가 -> 매개변수를 set해줘야하기 때문에(텍스트 SQL 호출)*/
			stmt.setString(1,"301-66-5754"); /*위의 ? 의 순서 (나름 인덱스...)*/
			stmt.setDouble(2,3000.0);
			stmt.setDouble(3,0.8);
			stmt.setDouble(4,20000.0);
			stmt.setString(5,"C");
			stmt.setLong(6,1002);
			stmt.executeUpdate();
			
			
			System.out.println("INSERTED.........");
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
