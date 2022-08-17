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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Bean.Transaction_Details;
import com.Persistence.helper.TransactionDetailsRowMapper;

@Repository
public class TransactionDetailsDaoImpl implements TransactionDetailsDao {

	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	

	@Override
	public void showalltransactionDetails() {    
		String query="SELECT * FROM transaction_details";
		List<Transaction_Details> list=jdbcTemplate.query(query, new TransactionDetailsRowMapper());
		
		System.out.println("Transaction_id    Item_Id    quantity");
			for(Transaction_Details td:list){
				int Transaction_id=td.getTransaction_ID();
				int Item_Id=td.getItem_ID();
	        int quantity=td.getQuantity();
	
				System.out.println(Transaction_id+" "+Item_Id+" "+quantity);
			}

	}


	@Override
	public boolean deletetransactionDetail(int id) {
		
		String query = "DELETE FROM Transaction_Details where transaction_ID=?";

		int rows = jdbcTemplate.update(query, id);
        if(rows>0)
		return true;
        else 
        	return false;
	}

	@Override
	public boolean addtransactionDetail(Transaction_Details trans_details) {
		String query = "INSERT INTO Transaction_Details values(?,?,?)";

		int rows = jdbcTemplate.update(query,trans_details.getTransaction_ID(),trans_details.getItem_ID(),trans_details.getQuantity() );
       if(rows>0)
		return true;
       else
    	   return false;
	}


	@Override
	public List<Transaction_Details> searchTransactionDetails(int transid) {
		
		String query="SELECT * FROM transaction_details where transaction_id=?";
		List<Transaction_Details> list=jdbcTemplate.query(query, new TransactionDetailsRowMapper(),transid);
		
		return list;
		
	}


	@Override
	public boolean deleteitemfromcart(int item_id) {
		
		String query = "DELETE FROM Transaction_Details where item_id=?";

		int rows = jdbcTemplate.update(query, item_id);
        if(rows>0)
		return true;
        else 
        	return false;
	}


	@Override
	public boolean updateitemquantity(int item_id, int quantity) {
		
		String query = "UPDATE transaction_details SET quantity=? where item_id=?";

		int rows = jdbcTemplate.update(query, quantity,item_id);
        if(rows>0)
		return true;
        else 
        	return false;
	}

}
