package com.samsung.sds.emarket.marketing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarketingApplication {
	public static void main(String[] args) {
		System.out.println("Hello, Spring");
		SpringApplication.run(MarketingApplication.class, args);
		System.out.println("Ok! Marketing Service Ready!!");
	}
}
