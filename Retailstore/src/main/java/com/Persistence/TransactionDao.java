package com.Persistence;

import java.util.List;

import com.Bean.Customer;
import com.Bean.Transaction;
import com.Bean.Transaction_Details;

public interface TransactionDao {
	List<Transaction> getAllTransactions();
	int addtransaction(Transaction transaction);
	int deletetransaction(int id);
	Transaction searchTransaction(int transid) ;
}
