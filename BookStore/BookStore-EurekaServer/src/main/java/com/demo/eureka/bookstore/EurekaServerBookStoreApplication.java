package com.demo.eureka.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerBookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerBookStoreApplication.class, args);
		System.out.println("Eureka server started");
	}

}
