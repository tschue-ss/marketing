package com.samsung.sds.emarket.marketing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class MarketingApplication {
	public static void main(String[] args) {
		System.out.println("Hello, Spring");
		SpringApplication.run(MarketingApplication.class, args);
	}

}
