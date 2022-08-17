package com.Persistence.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Bean.Item;

public class ItemRowMapper implements RowMapper<Item>{

	@Override
	public Item mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		int item_ID = resultSet.getInt("item_Id");
		String item_Name = resultSet.getString("item_Name");
		String item_Category = resultSet.getString("item_Category");
		int item_Quantity = resultSet.getInt("quantity");
		double item_price = resultSet.getDouble("price");
						
		Item i= new Item(item_ID,item_Name,item_Category,item_Quantity,item_price);
		return i;
	}

}
