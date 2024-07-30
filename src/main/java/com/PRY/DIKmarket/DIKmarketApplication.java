package com.PRY.DIKmarket;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;

@SpringBootApplication(exclude = ThymeleafAutoConfiguration.class)
public class DIKmarketApplication {
	public static void main(String[] args) {
		SpringApplication.run(DIKmarketApplication.class, args);
	}
}

