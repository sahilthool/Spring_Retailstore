package com.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Bean.Customer;
import com.Persistence.helper.CustomerRowMapper;

@Repository
public class CustomerDaoImp implements CustomerDao {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}



	@Override
	public int deleteCustomer(int id) {
		
		String query = "DELETE FROM customer where customer_Id=?";

		int rows = jdbcTemplate.update(query, id);

		return rows;		
		
	}

	@Override
	public Customer searchCustomer(int id) {
		
		Customer customer=null;
		try {
		String query="SELECT * FROM customer where customer_Id=?";
		customer=jdbcTemplate.queryForObject(query, new CustomerRowMapper(), id);
		}
		catch(EmptyResultDataAccessException ex) {
			return customer;
		}
		return customer;		
		
	}


	@Override
	public int addCustomer(Customer customer) {
		
		String query = "INSERT INTO Customer values(?,?,?,?)";

		int rows = jdbcTemplate.update(query, customer.getCustomer_ID(), customer.getCustomer_Name(), customer.getUser_Name(), customer.getPassword());

		return rows;		
		
	}

	@Override
	public List<Customer> getAllCustomer() {
		String query="SELECT * FROM Customer";
		List<Customer> cusList=jdbcTemplate.query(query, new CustomerRowMapper());
		
		return cusList;
	}


	

}
