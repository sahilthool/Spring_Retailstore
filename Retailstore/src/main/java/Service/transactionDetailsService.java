package Service;

import java.util.List;

import Bean.Cart;
import Bean.Transaction;
import Bean.Transaction_Details;

public interface transactionDetailsService {
	
	void showalltransactionDetails();
	boolean addtransactionDetail(Transaction_Details trans_details);
	boolean deletetransactionDetail(int id);
	List<Transaction_Details> searchTransactionDetails(int transid);
	boolean deleteitemfromcart(int item_id);
	boolean updateitemquantity(int item_id, int quantity);
	boolean addToCart(Cart cart);
}
