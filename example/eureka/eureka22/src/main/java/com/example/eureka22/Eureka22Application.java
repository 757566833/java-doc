package com.example.eureka22;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Eureka22Application {

	public static void main(String[] args) {
		SpringApplication.run(Eureka22Application.class, args);
	}

}
