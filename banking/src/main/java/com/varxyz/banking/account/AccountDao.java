package com.varxyz.banking.account;

import static java.sql.Types.*;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class AccountDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public AccountDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void addAccount(Account account) {
		String sql = "INSERT INTO Account1 (customerId, accountNum, accType, balance, interestRate, overAmount)"
				+ " VALUES(?, ?, ?, ?, ?, ?)";
		SavingAccount sa = null;
		CheckingAccount ca = null;
		Object[] args = null;
		int[] types = new int[] {BIGINT, CHAR, CHAR, DOUBLE, DOUBLE, DOUBLE};
		
		if(account instanceof SavingAccount) {
			sa = (SavingAccount)account;
			args = new Object[] {
					sa.getCustomer().getCid(), sa.getAccountNum(), String.valueOf(sa.getAccType()),
					sa.getBalance(), sa.getInterestRate(), 0.0
			};
		}else {
			ca = (CheckingAccount)account;
			args = new Object[] {
					ca.getCustomer().getCid(), ca.getAccountNum(), String.valueOf(ca.getAccType()),
					ca.getBalance(), 0.0, ca.getOverAmount()
			};
		}
			
		jdbcTemplate.update(sql, args, types);
		System.out.println("계좌신청 완료");
	}
	
	public List<Account> getAccounts(String userId) {
		String sql = "SELECT a.aid, a.customerId, a.accountNum, a.accType, a.balance, a.interestRate, a.overAmount, a.regDate "
				+ "FROM Account1 a INNER JOIN Customer1 c ON a.customerId = c.cid "
				+ "WHERE c.userId = ?";
		return jdbcTemplate.query(sql, new CustomerAccountRowMapper(), userId);
	}
	
	public void transfer(double money, String withdrawAccountNum, String depositAccountNum) {
		String sql = "UPDATE Account1 SET balance = balance - ? WHERE accountNum=?";
		String sql2 = "UPDATE Account1 SET balance = balance + ? WHERE accountNum=?";
		jdbcTemplate.update(sql, money, withdrawAccountNum);
		jdbcTemplate.update(sql2, money, depositAccountNum);
	}

//	public void saveInterest(String accountNum, double interestRate) {
//		String sql = "UPDATE Account SET balance = balance + "
//				+ "(balance * (balance / ?)) WHERE accountNum=?";
//		jdbcTemplate.update(sql, interestRate, accountNum);
//	}
//	
	
	
	public long getBalance(String accountNum) {
		String sql = "SELECT a.balance FROM Account1 a INNER JOIN Customer1 c ON"
				+ " a.customerId = c.cid WHERE a.accountNum=?";
		
		return jdbcTemplate.queryForObject(sql, Long.class, accountNum);
	}
	
	//@Transactional 사용해서 이체
	
}
