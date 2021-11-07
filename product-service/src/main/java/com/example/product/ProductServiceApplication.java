package com.example.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = { "com.example.product.resource" })
public class ProductServiceApplication {

	public static void main(final String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

}
