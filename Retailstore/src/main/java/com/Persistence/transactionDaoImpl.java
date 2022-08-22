package com.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Bean.Customer;
import com.Bean.Transaction;
import com.Bean.Transaction_Details;
import com.Persistence.helper.CustomerRowMapper;
import com.Persistence.helper.TransactionRowMapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class transactionDaoImpl implements TransactionDao {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Transaction> getAllTransactions() {
		String query="SELECT * FROM transaction";
		List<Transaction> transList=jdbcTemplate.query(query, new TransactionRowMapper());
		
		return transList;

	}

	@Override
	public int addtransaction(Transaction transaction) {
		
		String query = "INSERT INTO transaction values(?,?)";

		int rows = jdbcTemplate.update(query, transaction.getTransaction_ID(), transaction.getCustomer_ID());

		return rows;

	}

	@Override
	public int deletetransaction(int id) {
		
		String query = "DELETE FROM transaction where Transaction_id=?";

		int rows = jdbcTemplate.update(query, id);

		return rows;	


	}
	@Override
	public Transaction searchTransaction(int transid) {
		
		Transaction transaction=null;
		try {
		String query="SELECT * FROM transaction where Transaction_id=?";
		transaction=jdbcTemplate.queryForObject(query, new TransactionRowMapper(), transid);
		}
		catch(EmptyResultDataAccessException ex) {
			return transaction;
		}
		return transaction;
		
	}
	
}
