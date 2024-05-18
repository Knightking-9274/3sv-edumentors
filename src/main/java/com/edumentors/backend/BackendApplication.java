package com.edumentors.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
// @EnableJpaRepositories(basePackages = "com.edumentors.backend.repositories")
public class BackendApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(BackendApplication.class, args);
	}

}
