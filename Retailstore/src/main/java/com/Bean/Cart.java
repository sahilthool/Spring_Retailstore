package com.Bean;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Cart {
	 int customer_id;
	 int item_Id;
	 String item_Name;
	 int quantity;
	 double price;
}
