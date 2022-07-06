package com.varxyz.jv300.mod009;

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
	
}