package Persistence;

import java.util.List;

import Bean.Customer;
import Bean.Transaction;
import Bean.Transaction_Details;

public class main22 {
	public static void main(String args[])
	{
		TransactionDetailsDaoImpl t=new TransactionDetailsDaoImpl();
		t.showalltransactionDetails();
		List<Transaction_Details> list=(t.searchTransactionDetails(1));
		for(Transaction_Details td:list)
			System.out.println("llll"+td);
	//	Transaction_Details trans_details=new Transaction_Details(1,1,2);
		//System.out.println("Trans_details udated:"+t.addtransactionDetail(trans_details));
		//CustomerDaoImp c=new CustomerDaoImp();
		//c.showCustomer();
		
		//Customer cust=new Customer(5,"Teja", "teja@gmail.com","11111");
		//boolean row=c.addCustomer(cust);
	//	System.out.println("added "+row+" row");
	//	c.showCustomer();
	//	System.out.println(c.searchCustomer(1));
		
		transactionDaoImpl t1=new transactionDaoImpl();
		t1.showalltransactions();
		//Transaction transaction=new Transaction(5,1);
		//System.out.println("Transaction udated:"+t1.addtransaction(transaction));
		t1.showalltransactions();
			}

}
