 package com.varxyz.jvx330.jdbc.example5;

import static java.sql.Types.*;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.varxyz.jvx330.jdbc.Account;

//@Repository("accountDao") 밑에랑 같음(component) 예외처리 자동으로 해줌 이거 
@Component("accountDao")
public class AccountDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public AccountDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void addAccount(Account account) {
		String sql = "INSERT INTO Account (customerId, accountNum, accType, balance, interestRate, overAmount, regDate) "
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
	
	public List<Account> findAccountsBySsn(String ssn) {
		String sql = "SELECT a.aid, a.customerId, a.accountNum, a.accType, a.balance, a.interestRate,"
				+ " a.overAmount, a.regDate "
				+ "FROM Account a INNER JOIN Customer c ON a.customerId = c.cid "
				+ "WHERE c.ssn = ?";
		//c.email, c.passwd, c.name, c.ssn, c.phone, c.regDate 
		
		 
		return jdbcTemplate.query(sql, new CustomerAccountRowMapper(), ssn);
	}//CustomerAccountRowMapper 필요할때 마다 사용해서 빈으로 등록할 필요없어서 빈등록x
	
	public List<Account> findAccountsByCustomerId(long customerId) {
		String sql = "SELECT a.aid, a.customerId, a.accountNum, a.accType, a.balance, a.interestRate,"
				+ " a.overAmount, a.regDate "
				+ "FROM Account a INNER JOIN Customer c ON a.customerId = c.cid "
				+ "WHERE a.customerId = ?";
		return jdbcTemplate.query(sql, new CustomerAccountRowMapper(), customerId);
	}
}
