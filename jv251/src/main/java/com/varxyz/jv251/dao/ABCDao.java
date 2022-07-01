package com.varxyz.jv251.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ABCDao {
	private static String sql;
	private static Connection con = null;		
	
	public ABCDao() throws SQLException {
		try {
			con = ConnerctionManager.getConnection();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doSomething() {
		try {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				//doSomething
			} finally {
				rs.close();
				pstmt.close();
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
