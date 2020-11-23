package com.example.mongodbtest;

import com.example.mongodbtest.summaryClasses.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootMongoDBApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootMongoDBApplication.class, args);

		/*director = new Director()

		CarBuilder builder = new CarBuilder()
		director.constructSportsCar(builder)
		Car car = builder.getProduct()

		CarManualBuilder builder = new CarManualBuilder()
		director.constructSportsCar(builder)

		// The final product is often retrieved from a builder
		// object since the director isn't aware of and not
		// dependent on concrete builders and products.
		Manual manual = builder.getProduct()*/


	}

}
