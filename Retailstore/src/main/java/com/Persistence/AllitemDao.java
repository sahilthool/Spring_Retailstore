package com.Persistence;

import java.util.List;

import com.Bean.Item;

public interface AllitemDao {
	List<Item> showallitem();
	boolean additem(Item allItem);
	Item searchItem(int id);
	boolean deleteitem(int id);
	boolean updateQuantity(int item_id,int quantity);
}