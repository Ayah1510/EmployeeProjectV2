package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@Log4j2
public class EmployeeProjectV2Application {

	public static void main(String[] args) {
		log.info("Starting the application on port 8087");
		SpringApplication.run(EmployeeProjectV2Application.class, args);
	}

}
