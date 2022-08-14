package com.Service;

import java.util.List;

import com.Bean.Bill;
import com.Bean.Transaction;
import com.Bean.Transaction_Details;

public interface transactionService {
	
	//List<Bill> generatebill(int customer_id);
	void showbill(int customer_id);
	void showalltransactions();
	boolean addtransaction(Transaction transaction);
	boolean deletetransaction(int id);
	Transaction searchTransaction(int custid) ;
}
