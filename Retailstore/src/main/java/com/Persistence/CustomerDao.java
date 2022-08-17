package com.Persistence;

import java.util.List;

import com.Bean.Customer;

public interface CustomerDao {

	
	int addCustomer(Customer customer);
	int deleteCustomer(int id);
	Customer searchCustomer(int id);
	List<Customer> getAllCustomer();
}
