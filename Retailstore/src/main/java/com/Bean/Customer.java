package com.Bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
@Scope("session")
public class Customer {
	int customer_ID;
	String customer_Name;
	String User_Name;
	String password;
	

}
