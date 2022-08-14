package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com")
public class RetailstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetailstoreApplication.class, args);
	}

}
