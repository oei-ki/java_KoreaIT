package com.varxyz.jv251.dao;

import java.sql.*;
import java.util.*;

import com.varxyz.jv251.domain.Account;
import com.varxyz.jv251.domain.CheckingAccount;
import com.varxyz.jv251.domain.Customer;
import com.varxyz.jv251.domain.SavingsAccount;

public class AccountDao {
	
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
				con = DataSourceManager.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,ssn);
				rs = pstmt.executeQuery();
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
				DataSourceManager.close(rs,pstmt,con);	
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
				con = DataSourceManager.getConnection();
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
				DataSourceManager.close(pstmt,con);	
			}	
			System.out.println("NEW ACCOUNT INSERTED.....\n");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Account> findAccountsBySsn(String ssn){
	      String sql = "SELECT a.aid, a.accountNum, a.balance, a.interertRete, "
	            + "a.overdraft, a.accountType, c.name, c.ssm, c.phone, a.regDate "
	            + "FROM Account a INNER JOIN Customer c ON a.customerId = c.cid\r\n"
	            + "WHERE c.ssm = ?";
	      List<Account> list = new ArrayList<>();
	      
	      try {
	    	  	    	  
	         Connection con = null;
	         PreparedStatement pstmt = null;
	         ResultSet rs = null;
	         try {
	            con = DataSourceManager.getConnection();
	            pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, ssn);
	            rs = pstmt.executeQuery();
	            Account account = null;
	            while(rs.next()) {
	               if(rs.getString("accountType").charAt(0) == 'S') {
	                  account = new SavingsAccount(sql, 0.0);
	                  ((SavingsAccount)account).setInterestRate(
	                        rs.getDouble("interertRete"));
	                  account.setAccountType(rs.getString("accountType").charAt(0));
	               } else {
	                  account = new CheckingAccount();
	                  ((CheckingAccount)account).setOverdraftAmount(
	                        rs.getDouble("overdraft"));
	                  account.setAccountType(rs.getString("accountType").charAt(0));
	               }
	               account.setAid(rs.getLong("aid"));
	               account.setAccountNum(rs.getString("accountNum"));
	               account.setBalance(rs.getDouble("balance"));
	               account.setCustomer(new Customer(rs.getString("name"), 
	                     rs.getString("ssm"), rs.getString("phone")));
	               account.setRegDate(rs.getTimestamp("regDate"));
	               list.add(account);
	            }
	         } finally {
	            DataSourceManager.close(rs, pstmt, con);
	         }
	      }catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return list;
	   }
	
	public Account accountCheck(String accountNum) {
		String sql = "SELECT a.aid, a.accountNum, a.balance, a.interertRete, "
	            + "a.overdraft, a.accountType, c.name, c.ssm, c.phone, a.regDate "
	            + "FROM Account a INNER JOIN Customer c ON a.customerId = c.cid\r\n"
	            + "WHERE a.accountNum = ?";
		try {
			Connection con = null; //java db연결 객체
			PreparedStatement pstmt = null;//db전달
			ResultSet rs = null; //결과값 저장
			try {
				con = DataSourceManager.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,accountNum); //앞에 숫자는 ?의 인덱스라고 생각하면 됨
				rs = pstmt.executeQuery();
				Account account = null;
	            while(rs.next()) {
	               if(rs.getString("accountType").charAt(0) == 'S') {
	                  account = new SavingsAccount(sql, 0.0);
	                  ((SavingsAccount)account).setInterestRate(
	                        rs.getDouble("interertRete"));
	                  account.setAccountType(rs.getString("accountType").charAt(0));
	               } else {
	                  account = new CheckingAccount();
	                  ((CheckingAccount)account).setOverdraftAmount(
	                        rs.getDouble("overdraft"));
	                  account.setAccountType(rs.getString("accountType").charAt(0));
	               }
	               account.setAid(rs.getLong("aid"));
	               account.setAccountNum(rs.getString("accountNum"));
	               account.setBalance(rs.getDouble("balance"));
	               account.setCustomer(new Customer(rs.getString("name"), 
	                     rs.getString("ssm"), rs.getString("phone")));
	               account.setRegDate(rs.getTimestamp("regDate"));
	               return account;
	            }
			} finally  {
				DataSourceManager.close(rs,pstmt,con);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateAccount(Account account) {
		String sql = "UPDATE account SET balance=?, overdraft=? WHERE accountNum=?";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DataSourceManager.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setDouble(1, account.getBalance());
				pstmt.setString(3, account.getAccountNum());
				if(account instanceof SavingsAccount) {  //세이빙어카운트에만 있는 변수 getInterestRate 사용하기 위해 조건추가.
					SavingsAccount sa = (SavingsAccount)account; //다운캐스팅
					pstmt.setDouble(2, 0.0);
				}else {
					CheckingAccount ca = (CheckingAccount)account;
					pstmt.setDouble(2, ca.getOverdraftAmount());
				}
				pstmt.executeUpdate();
			} finally  {
				DataSourceManager.close(pstmt,con);	
			}	
			System.out.println("NEW ACCOUNT UPDATE.....\n");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
