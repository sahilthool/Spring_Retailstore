package com.Service;
import com.Bean.Item;
import com.Persistence.Allitemdaoimpl;

public class allitemServiceImpl implements allitemService {

	Allitemdaoimpl aa=new Allitemdaoimpl();
	@Override
	public void showallitem() {
		aa.showallitem();
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
