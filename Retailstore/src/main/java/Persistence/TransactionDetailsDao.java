package Persistence;

import java.util.List;
import Bean.Transaction_Details;

public interface TransactionDetailsDao {
	void showalltransactionDetails();
	boolean addtransactionDetail(Transaction_Details trans_details);
	boolean deletetransactionDetail(int id);
	boolean deleteitemfromcart(int item_id);
	boolean updateitemquantity(int item_id, int quantity);
	List<Transaction_Details> searchTransactionDetails(int transid);
}

