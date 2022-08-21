package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bean.Customer;
import com.Persistence.CustomerDao;
import com.Persistence.CustomerDaoImp;

@Service
public class customerServiceImpl implements customerService {
	
	
	private CustomerDao customerDao;
	
	@Autowired
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	
	@Override
	public boolean addCustomer(Customer customer) {
		if(customerDao.addCustomer(customer) > 0)
			return true;
		return false;
	}

	@Override
	public boolean deleteCustomer(int id) {
		if(customerDao.deleteCustomer(id)>0)
			return true;
		return false;
	}

	@Override
	public Customer searchCustomer(int id) {
		return customerDao.searchCustomer(id);
	}


	@Override
	public List<Customer> getAllCustomers() {
		return customerDao.getAllCustomer();
	}


	@Override
	public boolean checkCustomer(Customer customer) {
		if(customerDao.getCustomer(customer.getUser_Name(), customer.getPassword())!=null)
			return true;
		return false;
	}


	@Override
	public int searchCustomerID(String username) {
		return customerDao.searchCustomerID(username);
	}

	

	
}
