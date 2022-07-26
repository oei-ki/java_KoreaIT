package com.varxyz.banking;

import static java.sql.Types.BIGINT;
import static java.sql.Types.CHAR;
import static java.sql.Types.DOUBLE;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.varxyz.banking.cutomer.CustomerAccountRowMapper;

public class AccountDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public AccountDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void addAccount(Account account) {
		String sql = "INSERT INTO Account1 (customerId, accountNum, accType, balance, interestRate, overAmount, regDate) "
				+ "VALUES (?,?,?,?,?,?,?)";
		SavingAccount sa = null;
		CheckingAccount ca = null;
		Object[] args = null;
		int[] types = new int[] {CHAR, CHAR, DOUBLE, DOUBLE, DOUBLE, BIGINT};
		
		if(account instanceof SavingAccount) {
			sa = (SavingAccount)account;
			args = new Object[] {
					sa.getAccountNum(), String.valueOf(sa.getAccType()),
					sa.getBalance(), sa.getInterestRate(), 0.0,
					sa.getCustomer().getCid()
			};
		}else {
			ca = (CheckingAccount)account;
			args = new Object[] {
					ca.getAccountNum(), String.valueOf(ca.getAccType()),
					ca.getBalance(), ca.getOverDraftAmount(), 0.0,
					ca.getCustomer().getCid()
			};
		jdbcTemplate.update(sql, args, types);
		
		}
	}
	
	public List<Account> getAccounts(long customerId) {
		String sql = "SELECT a.aid, a.customerId, a.accountNum, a.accType, a.balance, a.interestRate,"
				+ " a.overAmount, a.regDate "
				+ "FROM Account1 a INNER JOIN Customer1 c ON a.customerId = c.cid "
				+ "WHERE a.customerId = ?";
		return jdbcTemplate.query(sql, new CustomerAccountRowMapper(), customerId);
	}
	
	

	
	public List<Account> getBalance(String accountNum) {
		String sql = "SELECT a.aid, a.customerId, a.accountNum, a.accType, a.balance "
				+ "FROM Account1 a INNER JOIN Customer1 c ON a.customerId = c.cid "
				+ "WHERE a.accountNum = ?";
		
		return jdbcTemplate.query(sql, new CustomerAccountRowMapper(), accountNum);
	}
	
	
}
