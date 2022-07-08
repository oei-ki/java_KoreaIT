package com.varxyz.jv300.mod010;

import java.sql.*;
import java.util.*;

public class UserDao {
	
	private DataSource dataSource;
	
	public UserDao() {		
		NamingService namingService = NamingService.getInstance();
		dataSource = (DataSource)namingService.getAttribute("dataSource");
	}
	
	public void userUpload(User user){
		String sql = "INSERT INTO Users(userId, passwd, userName, ssn, email, addr)" + " VALUES (?,?,?,?,?,?)";
		
		 try {
			 Connection con = null;
			 PreparedStatement pstmt = null;
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user.getUserId());
				pstmt.setString(2, user.getPasswd());
				pstmt.setString(3, user.getUserName());
				pstmt.setString(4, user.getSsn());
				pstmt.setString(5, user.getEmail());
				pstmt.setString(6, user.getAddr());
				pstmt.executeUpdate();
				} finally {
					dataSource.close(pstmt,con);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<User> findAllUsers(){
		String sql = "SELECT * FROM Users";
		List<User> userList = new ArrayList<>();
		
		 try {
			 Connection con = null;
			 PreparedStatement pstmt = null;
			 ResultSet rs = null;
			try {
				con = dataSource.getConnection();  //DriverManager.getConnection 코드를 바꿔도 상관없다?? DataSourceManager메소드에서 연결시키기 때문에?
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					User c = new User();
					c.setUserId(rs.getString("userId"));
					c.setPasswd(rs.getString("passwd"));
					c.setUserName(rs.getString("userName"));
					c.setSsn(rs.getString("ssn"));
					c.setEmail(rs.getString("email"));
					c.setAddr(rs.getString("addr"));
					userList.add(c);
					}
				} finally {
					dataSource.close(rs,pstmt,con);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	public boolean isValidUser(String userId, String passwd) { //주민번호로 고객조회하는 메소드
		String sql = "SELECT * FROM Users WHERE userId= ? AND passwd=? ";
		boolean boo = true;
		try {
			 Connection con = null;
			 PreparedStatement pstmt = null;
			 ResultSet rs = null;
			 try {
				 con = dataSource.getConnection();
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, userId); //위 where?로 조회하는거임
					pstmt.setString(2, passwd);
					rs = pstmt.executeQuery();  /*rs 객체의 값을 반환 , SELECT 구문을 수행*/
					if(!rs.next()) {
						boo = false;
					}
			} finally {
				dataSource.close(rs,pstmt,con);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boo;
	}
	
}