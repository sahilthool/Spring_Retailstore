package com.Bean;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Item {
	int item_ID;
	String item_Name;
	String item_Category;
	int item_Quantity;
	double item_Price;	

}
