package com.Service;

import java.util.List;

import com.Bean.Cart;

public interface generate_billService {
	
	List<Cart> generate_bill(int customer_id);
	double total_bill(int customer_id);

}
