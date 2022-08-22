package com.Service;

import java.util.List;

import com.Bean.Bill;
import com.Bean.Transaction;
import com.Bean.Transaction_Details;

public interface transactionService {
		
	List<Transaction> getAllTransactions();
	boolean addtransaction(Transaction transaction);
	boolean deletetransaction(int id);
	Transaction searchTransaction(int transid) ;
	int getTransactionId(int custId);
}
