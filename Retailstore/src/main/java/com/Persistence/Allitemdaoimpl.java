package com.Persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Bean.Item;
import com.Persistence.helper.ItemRowMapper;

@Repository
public class Allitemdaoimpl implements AllitemDao {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void showallitem() {
		
		String query="SELECT * FROM allItems";
		List<Item> list=jdbcTemplate.query(query, new ItemRowMapper());
		
		System.out.println("ItemId    Item Name    Category        Quantity      Price");
			for(Item i:list){
				
		        int item_ID = i.getItem_ID();
				String item_Name = i.getItem_Name();
				String item_Category = i.getItem_Category();
				int item_Quantity = i.getItem_Quantity();
				double item_price = i.getItem_Price();
	
				System.out.println(item_ID +" "+item_Name+" "+item_Category+" "+item_Quantity+" "+item_price);

			}
	}

	@Override

	public boolean additem(Item item) {
		
		String query = "INSERT INTO allItems values(?,?,?,?,?)";
		int rows = jdbcTemplate.update(query,item.getItem_ID(),item.getItem_Name(),item.getItem_Category(),item.getItem_Quantity(),item.getItem_Price());
       if(rows>0)
		return true;
       else
    	   return false;
	}

	

	@Override
	public boolean deleteitem(int id) {
		
		String query = "DELETE FROM allItems where item_Id=?";

		int rows = jdbcTemplate.update(query, id);
        if(rows>0)
		return true;
        else 
        	return false;
	}
	
	
	@Override
	public Item searchItem(int id) {
		
		String query="SELECT * FROM allItems where item_Id=?";
		Item item=(Item) jdbcTemplate.query(query, new ItemRowMapper(),id);
		
		return item;
	}

	@Override
	public boolean updateQuantity(int item_id,int reduce_quantity) {
		
		String query = "Update allitems set quantity=quantity-? where item_id=?";
		int rows = jdbcTemplate.update(query, item_id,reduce_quantity);
        if(rows>0)
		return true;
        else 
        	return false;
	}

}
