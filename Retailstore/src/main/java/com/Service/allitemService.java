package com.Service;

import com.Bean.Item;

public interface allitemService {
	
	void showallitem();
	boolean additem(Item allItem);
	Item searchItem(int id);
	boolean deleteitem(int id);
	boolean updateQuantity(int item_id,int quantity);
}
