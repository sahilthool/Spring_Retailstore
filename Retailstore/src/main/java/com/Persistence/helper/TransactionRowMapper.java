package com.Persistence.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Bean.Customer;
import com.Bean.Transaction;

public class TransactionRowMapper implements RowMapper<Transaction>{

	@Override
	public Transaction mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		
		int transaction_id = resultSet.getInt("Transaction_id");
		int customer_id = resultSet.getInt("customer_id");
				

		Transaction transaction = new Transaction(transaction_id, customer_id);
		return transaction;
		
	}

}
