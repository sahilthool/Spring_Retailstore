package Persistence;

import Bean.Customer;

public interface CustomerDao {

	
	boolean addCustomer(Customer customer);
	boolean deleteCustomer(int id);
	Customer searchCustomer(int id);
	void showCustomer();
}
