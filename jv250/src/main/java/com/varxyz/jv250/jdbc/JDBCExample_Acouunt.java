package com.varxyz.jv250.jdbc;

import java.sql.*;  /*static method????*/
/*기본방식*/
public class JDBCExample_Acouunt {
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
			
			String sql = "SELECT * FROM Account WHERE accountNum='301-11-2548'";
			Statement stmt = con.createStatement(); /*Statement - SQL 구문을 실행하는 역할(전달역할)*/
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {  /*다음칸으로 넘어가면서 true와 false를 구별함*/
				long aid = rs.getLong("aid");
				String accountNum = rs.getString("accountNum");
				double balance = rs.getDouble("balance");
				double interertRete  = rs.getDouble("interertRete");
				System.out.println(aid);
				System.out.println(accountNum);
				System.out.println(balance);
				System.out.println(interertRete);
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
