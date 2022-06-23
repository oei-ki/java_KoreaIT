package com.varxyz.jv250.bangking;

import java.sql.*;


public class AccountJdbcTest {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jv250?severTimezone=Asia/Seoul";
		String id = "jv250";
		String passwd = "jv250";
		
		try {				
			Class.forName(driver); //driver 객제가 생성됨.
			System.out.println("LOADED DRIVER ------>" + driver); 
			
			
			Connection con = DriverManager.getConnection(url, id, passwd); //데이터베이스와 연결하는 객체
			System.out.println("CONNECTED TO ------->" + url); //연결한 url 확인
			
			select(con); //실행
			insert(con); //삽입
			select(con); //다시 실행해서 넣은값 불러온 거
			con.close(); //데이터베이스 종료..
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void select(Connection con) { //Connection con 내가 만들어 놓은 데이터베이스
		String sql = "SELECT * FROM Account";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql); //값을 연결해서 실행시킬 곳 미리 실행된 창을 사용
			ResultSet rs = pstmt.executeQuery(); //실행시킨 값을 저장한 곳  //executeQuery 실행시킴
			while(rs.next()) { //한 줄씩 참(값이 있으면) 거짓(값이 없으면)을 구분한다.
				long aid = rs.getLong("aid");
				String accountNum = rs.getString("accountNum");
				double balance = rs.getDouble("balance");
				double interertRete = rs.getDouble("interertRete");
				double overdraft = rs.getDouble("overdraft");
				char accountType = rs.getString("accountType").charAt(0);
				System.out.println(aid);
				System.out.println(accountNum);
				System.out.println(balance);
				System.out.println(interertRete);
				System.out.println(overdraft);
				System.out.println(accountType);	
				System.out.println("------------------------");	
			}
			rs.close();
			pstmt.close();
			System.out.println("SELECT COMPLETED...\n");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void insert(Connection con) {
		String sql = "INSERT INTO Account(accountNum, balance, interertRete," + "overdraft, accountType, customerId)"
					+ "VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "456-78-9012");
			pstmt.setDouble(2, 3000.0);
			pstmt.setDouble(3, 0.03);
			pstmt.setDouble(4, 0.0);
			pstmt.setString(5, String.valueOf('S'));
			pstmt.setLong(6, 1002);
			
			pstmt.executeUpdate();  //
			pstmt.close();
			System.out.println("NEW ACCOUNT INSERTED.....\n");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
	



