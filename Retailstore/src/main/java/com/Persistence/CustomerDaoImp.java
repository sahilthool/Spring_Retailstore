package com.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Bean.Customer;

public class CustomerDaoImp implements CustomerDao {

	@Override
	public void showCustomer() {
		try( Connection connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/retailstore", "root", "wiley");
				Statement statement=connection.createStatement();	) {

			ResultSet resultSet= statement.executeQuery("SELECT * FROM customer");
			
			while(resultSet.next()) {
				int customer_id=resultSet.getInt("customer_Id");
				String customer_name=resultSet.getString("customer_Name");
				String user_name=resultSet.getString("User_Name");
				String password=resultSet.getString("passwords");
								
				System.out.println(customer_id +" "+customer_name+" "+user_name+" "+password);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean deleteCustomer(int id) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/retailstore", "root",
				"wiley");
				PreparedStatement preparedStatement = connection
						.prepareStatement("DELETE FROM customer where customer_Id=?");) {

			preparedStatement.setInt(1,id);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				System.out.println("Customer Data Deleted");
				return true;
			}
			else {
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public Customer searchCustomer(int id) {
		Customer cust=null;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/retailstore", "root",
				"wiley");
				PreparedStatement preparedStatement = connection
						.prepareStatement("SELECT * FROM customer where customer_Id=?");) {

			preparedStatement.setInt(1,id);

			ResultSet resultSet = preparedStatement.executeQuery();
            
			if (resultSet.next()) {
				int id1 = resultSet.getInt("customer_Id");
				String customer_Name=resultSet.getString("customer_Name");
				String userName=resultSet.getString("User_Name");
				String password=resultSet.getString("passwords");
				cust=new Customer(id1,customer_Name,userName,password);
				return cust;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cust;
		
		
	}


	@Override
	public boolean addCustomer(Customer customer) {
		int rows = 0;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/retailstore", "root",
				"wiley");
				PreparedStatement preparedStatement = connection
						.prepareStatement("INSERT INTO Customer values(?,?,?,?)");) {

			preparedStatement.setInt(1, customer.getCustomer_ID());
			preparedStatement.setString(2, customer.getCustomer_Name());
			preparedStatement.setString(3, customer.getUser_Name());
			preparedStatement.setString(4, customer.getPassword());
			

			rows = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (rows>0)
		   return true;
		else
			return false;
		
	}


	

}
