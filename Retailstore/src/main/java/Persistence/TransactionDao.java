package Persistence;

import Bean.Transaction;
import Bean.Transaction_Details;

public interface TransactionDao {
	void showalltransactions();
	boolean addtransaction(Transaction transaction);
	boolean deletetransaction(int id);
	Transaction searchTransaction(int custid) ;
}
