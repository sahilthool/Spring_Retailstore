package Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Bean.Transaction;
import Bean.Transaction_Details;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class transactionDaoImpl implements TransactionDao {

	@Override
	public void showalltransactions() {
		try( Connection connection=DriverManager.
				getConnection("jdbc:mysql://127.0.0.1:3306/retailstore", "root", "wiley");
				Statement statement=connection.createStatement();	) {

			ResultSet resultSet= statement.executeQuery("SELECT * FROM Transaction");
			
			while(resultSet.next()) {
				int Transaction_ID=resultSet.getInt("Transaction_Id");
				int Customer_ID=resultSet.getInt("Customer_ID");

				
				System.out.println(Transaction_ID+" "+Customer_ID);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean addtransaction(Transaction transaction) {
		int rows = 0;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/retailstore", "root",
				"wiley");
				PreparedStatement preparedStatement = connection
						.prepareStatement("INSERT INTO Transaction values(?,?)");) {

			preparedStatement.setInt(1, transaction.getTransaction_ID());
			preparedStatement.setInt(2, transaction.getCustomer_ID());
			
			

			rows = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (rows>0)
		   return true;
		else
			return false;

	}

	@Override
	public boolean deletetransaction(int id) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/retailstore", "root",
				"wiley");
				PreparedStatement preparedStatement = connection
						.prepareStatement("DELETE FROM transaction where transaction_Id=?");) {

			preparedStatement.setInt(1,id);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				//System.out.println("Deleted");
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
	public Transaction searchTransaction(int custid) {
		Transaction list=null;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/retailstore", "root",
				"wiley");
				PreparedStatement preparedStatement = connection
						.prepareStatement("SELECT * FROM transaction where customer_id=?");) {

			preparedStatement.setInt(1,custid);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int id1 = resultSet.getInt("transaction_Id");
				int id2 = resultSet.getInt("customer_Id");
				//int quantity = resultSet.getInt("quantity");
				
				list=new Transaction(id1,id2);
				//list.add(new Transaction_Details(id1,id2,quantity) );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
}
