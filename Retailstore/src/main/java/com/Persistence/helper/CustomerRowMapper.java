package com.Persistence.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Bean.Customer;

public class CustomerRowMapper implements RowMapper<Customer>{

	@Override
	public Customer mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		
		int id = resultSet.getInt("customer_Id");
		String cus_name = resultSet.getString("customer_Name");
		String user_name = resultSet.getString("user_Name");
		String pwd = resultSet.getString("passwords");
		

		Customer customer = new Customer(id,cus_name, user_name, pwd);
		return customer;
		
	}
	
	

}
