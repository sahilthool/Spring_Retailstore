package com.Service;

import java.util.List;

import com.Bean.Item;

public interface allitemService {
	
	List<Item> showallitem();
	boolean additem(Item allItem);
	Item searchItem(int id);
	boolean deleteitem(int id);
	boolean updateQuantity(int item_id,int quantity);
}
