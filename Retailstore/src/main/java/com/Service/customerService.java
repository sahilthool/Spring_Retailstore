package com.Service;

import java.util.List;

import com.Bean.Customer;

public interface customerService {
	
	boolean addCustomer(Customer customer);
	boolean deleteCustomer(int id);
	Customer searchCustomer(int id);
	List<Customer> getAllCustomers();
	boolean checkCustomer(Customer customer);

}
