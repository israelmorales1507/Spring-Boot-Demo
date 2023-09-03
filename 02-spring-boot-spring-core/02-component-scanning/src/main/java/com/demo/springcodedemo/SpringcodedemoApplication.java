package com.demo.springcodedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(
//		scanBasePackages = {
//				"com.demo.util",
//				"com.demo.springcodedemo",
//		}
//)

@SpringBootApplication
public class SpringcodedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcodedemoApplication.class, args);
	}
}