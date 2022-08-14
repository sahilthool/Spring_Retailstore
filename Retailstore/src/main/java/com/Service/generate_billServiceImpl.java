package com.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Bean.Bill;
import com.Bean.Customer;
import com.Bean.Item;
import com.Bean.Transaction;
import com.Bean.Transaction_Details;
import com.Persistence.TransactionDetailsDaoImpl;

public class generate_billServiceImpl implements generate_billService {

		
	@Override
	public void generate_bill(int customer_id) {
		customerServiceImpl custservice=new customerServiceImpl();
		//int customer_id2=custservice.searchCustomer(customer_id);
		
		transactionServiceImpl transervice=new transactionServiceImpl();
		Transaction transaction=transervice.searchTransaction(customer_id);
		int transaction_id=transaction.getTransaction_ID();
		
		transactionDetailsServiceImpl transaction_details =new transactionDetailsServiceImpl();
		List<Transaction_Details> list=new ArrayList<Transaction_Details>();
		list=transaction_details.searchTransactionDetails(transaction_id);
		
		System.out.println("Generated Bill : ");
		System.out.println("Customer Id :"+customer_id);
		//System.out.println("Customer Name:"+customer.getCustomer_Name());
		System.out.println("Transaction Id : "+transaction_id);
		
		double grand_total=0.0;
		final double Cd_tax=0.1,Cosmetics_tax=0.12;
		for(Transaction_Details tdd:list) {
			
			System.out.println("Item_id"+tdd.getItem_ID());
			
			allitemServiceImpl itemservice=new allitemServiceImpl();
			Item item=itemservice.searchItem(tdd.getItem_ID());
			
			System.out.println("Item_name:"+item.getItem_Name());
             System.out.println("Item Quantity:"+tdd.getQuantity());
             System.out.println("Price:"+item.getItem_Price());
             String item_category=item.getItem_Category();
              
             if(item_category=="CD")
           	  grand_total=grand_total+item.getItem_Price()*Cd_tax ;
             else if(item_category=="Cosmetics")
           	  grand_total=grand_total+item.getItem_Price()*tdd.getQuantity()*Cosmetics_tax;
             else
           	  grand_total=grand_total+item.getItem_Price()*tdd.getQuantity();
		}
		System.out.println("Grand Total : "+grand_total);
	}
			
}

