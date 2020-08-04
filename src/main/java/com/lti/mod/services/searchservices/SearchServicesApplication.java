package com.lti.mod.services.searchservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class SearchServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchServicesApplication.class, args);
	}

}
