package com.Bean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Bill {
	int customer_id;
	int transaction_id;
	String Customer_Name;
	 int item_Id;
	 String item_Name;
	 int quantity;
	 double price;
}
