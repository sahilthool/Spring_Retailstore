package Service;

import Bean.Customer;

public interface customerService {
	
	boolean addCustomer(Customer customer);
	boolean deleteCustomer(int id);
	Customer searchCustomer(int id);
	void showCustomer();

}
