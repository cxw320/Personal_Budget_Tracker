package com.example.mongodbtest;

import com.example.mongodbtest.summaryClasses.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootMongoDBApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootMongoDBApplication.class, args);


		// The final product is often retrieved from a builder
		// object since the director isn't aware of and not
		// dependent on concrete builders and products.


	}

}
