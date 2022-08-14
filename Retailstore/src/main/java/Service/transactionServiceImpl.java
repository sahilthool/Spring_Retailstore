package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.Bill;
import Bean.Transaction;
import Bean.Transaction_Details;
import Persistence.TransactionDetailsDaoImpl;
import Persistence.transactionDaoImpl;

public class transactionServiceImpl implements transactionService {
	transactionDaoImpl td=new transactionDaoImpl();
	
	@Override
	public void showbill(int customer_id) {
		
	}
	@Override
	public void showalltransactions() {
		td.showalltransactions();
		
	}
	@Override
	public boolean addtransaction(Transaction transaction) {
		
		return td.addtransaction(transaction);
	}
	@Override
	public boolean deletetransaction(int id) {
		return td.deletetransaction(id);
	}
	@Override
	public Transaction searchTransaction(int custid) {
		return td.searchTransaction(custid);
	}

	
	

}
