package com.varxyz.jv250.bangking;

import java.sql.*;
import java.util.*;

public class AccountDao {
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/jv250?severTimezone=Asia/Seoul";
	private static final String JDBC_USER = "jv250";
	private static final String JDBC_PASSWORD = "jv250";
	
	public AccountDao() { //드라이버 생성
		try {
			Class.forName(JDBC_DRIVER); //드라이버 객체 생성
			System.out.println("LOADER DRIVER---------->" + JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public List<Account> findAllAccountsBySsn(String ssn) { 
		String sql = "SELECT a.aid, a.accountNum, a.balance, a.interertRete,"
		+"a.overdraft, a.accountType, c.name, c.ssm, c.phone, a.regDate"
		+ " FROM Account a INNER JOIN Customer c ON a.customerId = c.cid"
		+ " WHERE c.ssm = ?";
		List<Account> list = new ArrayList<>();
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,ssn);
				rs = pstmt.executeQuery();
				System.out.println(rs);
				Account account = null;
				while(rs.next()) {
					if(rs.getString("accountType").charAt(0) == 'S') {
						account = new SavingsAccount();
						((SavingsAccount)account).setInterestRate(
								rs.getDouble("interertRete"));
					}else {
						account = new CheckingAccount();
						((CheckingAccount)account).setOverdraftAmount(
								rs.getDouble("overdraft"));
					}
					account.setAid(rs.getLong("aid"));
					account.setAccountNum(rs.getString("accountNum"));
					account.setBalance(rs.getDouble("balance"));
					account.setCustomer(new Customer(rs.getString("name"),
							rs.getString("ssm"),rs.getString("phone")));
					account.setRegDate(rs.getTimestamp("regDate"));
					list.add(account);
				}
			} finally  {
				rs.close();
				pstmt.close();
				con.close();	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	
	
	public void addAccount(Account account) {
		String sql = "INSERT INTO Account(accountNum,balance,interertRete,overdraft,accountType,customerId)" + "VALUES(?,?,?,?,?,?)";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, account.getAccountNum());
				pstmt.setDouble(2, account.getBalance());
				if(account instanceof SavingsAccount) {  //세이빙어카운트에만 있는 변수 getInterestRate 사용하기 위해 조건추가.
					SavingsAccount sa = (SavingsAccount)account; //다운캐스팅
					pstmt.setDouble(3, sa.getInterestRate());
					pstmt.setDouble(4, 0.0);
					pstmt.setString(5, String.valueOf('S'));
				}else {
					CheckingAccount ca = (CheckingAccount)account;
					pstmt.setDouble(3, 0.0);
					pstmt.setDouble(4, ca.getOverdraftAmount());
					pstmt.setString(5, String.valueOf('C'));
				}
				pstmt.setLong(6, account.getCustomer().getCid()); //이거 모르겠음
				pstmt.executeUpdate();
			} finally  {
				pstmt.close();
				con.close();
			}	
			System.out.println("NEW ACCOUNT INSERTED.....\n");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
