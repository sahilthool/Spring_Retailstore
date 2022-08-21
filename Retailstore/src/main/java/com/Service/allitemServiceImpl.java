package com.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bean.Item;
import com.Persistence.AllitemDao;
import com.Persistence.Allitemdaoimpl;
import com.Persistence.CustomerDao;

@Service
public class allitemServiceImpl implements allitemService {
	
	
	private AllitemDao aa;

	@Autowired
	public void setAllitemDao(AllitemDao aa) {
		this.aa= aa;
	}
	
	@Override
	public List<Item> showallitem() {
		return aa.showallitem();
	}

	@Override
	public boolean additem(Item allItem) {
		return aa.additem(allItem);
	}

	@Override
	public Item searchItem(int id) {
		return aa.searchItem(id);
	}

	@Override
	public boolean deleteitem(int id) {
		return aa.deleteitem(id);
	}

	@Override
	public boolean updateQuantity(int item_id, int quantity) {
		return aa.updateQuantity(item_id, quantity);
	}

	

}
