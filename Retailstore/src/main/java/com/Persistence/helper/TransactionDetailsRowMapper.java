package com.Persistence.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Bean.Transaction_Details;

public class TransactionDetailsRowMapper implements RowMapper<Transaction_Details>{

	@Override
	public Transaction_Details mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		int id = resultSet.getInt("transaction_ID");
		int item_id = resultSet.getInt("item_ID");
		int quan=resultSet.getInt("quantity");

		Transaction_Details td=new Transaction_Details(id,item_id,quan);
		return td;
	}

}
