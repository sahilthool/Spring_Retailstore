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
import com.Bean.Cart;
import com.Bean.Customer;
import com.Bean.Item;
import com.Bean.Transaction;
import com.Bean.Transaction_Details;
import com.Persistence.TransactionDetailsDaoImpl;
@Service
public class generate_billServiceImpl implements generate_billService {

		
	private transactionServiceImpl transervice;
	
	private transactionDetailsServiceImpl transaction_details ;
	
	@Autowired
	public void setTranservice(transactionServiceImpl transervice) {
		this.transervice = transervice;
	}

    @Autowired
	public void setTransaction_details(transactionDetailsServiceImpl transaction_details) {
		this.transaction_details = transaction_details;
	}


	@Override
	public List<Cart> generate_bill(int customer_id) {
		
		List<Cart> cart=new ArrayList<Cart>();
		customerServiceImpl custservice=new customerServiceImpl();
		//int customer_id2=custservice.searchCustomer(customer_id);
		
		
		Transaction transaction=transervice.searchTransaction(customer_id);
		int transaction_id=transaction.getTransaction_ID();
		
	
		List<Transaction_Details> list=new ArrayList<Transaction_Details>();
		list=transaction_details.searchTransactionDetails(transaction_id);
		
		System.out.println("Generated Bill : ");
		System.out.println("Customer Id :"+customer_id);
		//System.out.println("Customer Name:"+customer.getCustomer_Name());
		System.out.println("Transaction Id : "+transaction_id);
		
		double grand_total=0.0;
		final double Cd_tax=0.1,Cosmetics_tax=0.12;
		for(Transaction_Details tdd:list) {
			
			//System.out.println("Item_id"+tdd.getItem_ID());
			
			allitemServiceImpl itemservice=new allitemServiceImpl();
			Item item=itemservice.searchItem(tdd.getItem_ID());
			
		//	System.out.println("Item_name:"+item.getItem_Name());
          //   System.out.println("Item Quantity:"+tdd.getQuantity());
            // System.out.println("Price:"+item.getItem_Price());
             
             cart.add(new Cart(customer_id,tdd.getItem_ID(),item.getItem_Name(),tdd.getQuantity(),item.getItem_Price()));
             
             String item_category=item.getItem_Category();
              
             if(item_category=="CD")
           	  grand_total=grand_total+item.getItem_Price()*Cd_tax ;
             else if(item_category=="Cosmetics")
           	  grand_total=grand_total+item.getItem_Price()*tdd.getQuantity()*Cosmetics_tax;
             else
           	  grand_total=grand_total+item.getItem_Price()*tdd.getQuantity();
		}
		System.out.println("Grand Total : "+grand_total);
		return cart;
	}
	
	@Override
	public double total_bill(int customer_id) {
		
		List<Cart> cart=new ArrayList<Cart>();
		customerServiceImpl custservice=new customerServiceImpl();
		//int customer_id2=custservice.searchCustomer(customer_id);
		
		
		Transaction transaction=transervice.searchTransaction(customer_id);
		int transaction_id=transaction.getTransaction_ID();
		
	
		List<Transaction_Details> list=new ArrayList<Transaction_Details>();
		list=transaction_details.searchTransactionDetails(transaction_id);
		
		//System.out.println("Generated Bill : ");
		//System.out.println("Customer Id :"+customer_id);
		//System.out.println("Customer Name:"+customer.getCustomer_Name());
		//System.out.println("Transaction Id : "+transaction_id);
		
		double grand_total=0.0;
		final double Cd_tax=0.1,Cosmetics_tax=0.12;
		for(Transaction_Details tdd:list) {
			
			//System.out.println("Item_id"+tdd.getItem_ID());
			
			allitemServiceImpl itemservice=new allitemServiceImpl();
			Item item=itemservice.searchItem(tdd.getItem_ID());
			
		//	System.out.println("Item_name:"+item.getItem_Name());
          //   System.out.println("Item Quantity:"+tdd.getQuantity());
            // System.out.println("Price:"+item.getItem_Price());
             
             cart.add(new Cart(customer_id,tdd.getItem_ID(),item.getItem_Name(),tdd.getQuantity(),item.getItem_Price()));
             
             String item_category=item.getItem_Category();
              
             if(item_category=="CD")
           	  grand_total=grand_total+item.getItem_Price()*Cd_tax ;
             else if(item_category=="Cosmetics")
           	  grand_total=grand_total+item.getItem_Price()*tdd.getQuantity()*Cosmetics_tax;
             else
           	  grand_total=grand_total+item.getItem_Price()*tdd.getQuantity();
		}
		//System.out.println("Grand Total : "+grand_total);
		return grand_total;
	}
			
}

