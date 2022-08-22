package com.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bean.Bill;
import com.Bean.Customer;
import com.Bean.Transaction;
import com.Bean.Transaction_Details;
import com.Persistence.TransactionDao;
import com.Persistence.TransactionDetailsDaoImpl;
import com.Persistence.transactionDaoImpl;
@Service
public class transactionServiceImpl implements transactionService {
	
	private TransactionDao transactionDao;
	
	@Autowired
	public void setTransactionDao(TransactionDao transactionDao) {
		this.transactionDao = transactionDao;
	}
	
	
	@Override
	public List<Transaction> getAllTransactions() {
		return transactionDao.getAllTransactions();
		
	}
	
	@Override
	public boolean addtransaction(Transaction transaction) {		
		if(transactionDao.addtransaction(transaction) > 0)
			return true;
		return false;
	}
	
	@Override
	public boolean deletetransaction(int id) {
		if(transactionDao.deletetransaction(id)>0)
			return true;
		return false;
	}
	
	@Override
	public Transaction searchTransaction(int transid) {
		return transactionDao.searchTransaction(transid);
	}


	@Override
	public int getTransactionId(int custId) {
		return transactionDao.getTransactionId(custId);
	}

	
	

}
