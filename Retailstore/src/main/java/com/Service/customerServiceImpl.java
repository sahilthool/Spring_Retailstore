package com.Service;

import com.Bean.Customer;
import com.Persistence.CustomerDaoImp;

public class customerServiceImpl implements customerService {
	CustomerDaoImp cd=new CustomerDaoImp();
	@Override
	public boolean addCustomer(Customer customer) {
		return cd.addCustomer(customer);
	}

	@Override
	public boolean deleteCustomer(int id) {
		return cd.deleteCustomer(id);
	}

	@Override
	public Customer searchCustomer(int id) {
		return cd.searchCustomer(id);
	}

	@Override
	public void showCustomer() {
		cd.showCustomer();
	}

	
}
