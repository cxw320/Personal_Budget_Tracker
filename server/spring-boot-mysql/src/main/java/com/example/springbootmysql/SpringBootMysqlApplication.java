package com.example.springbootmysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.example.springbootmysql.controller","com.example.springbootmysql.repository",
		"com.example.springbootmysql.entity","com.example.springbootmysql.service"})
public class SpringBootMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMysqlApplication.class, args);

	}

}
