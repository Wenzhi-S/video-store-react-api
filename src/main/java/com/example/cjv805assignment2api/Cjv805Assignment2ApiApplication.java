package com.example.cjv805assignment2api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Cjv805Assignment2ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Cjv805Assignment2ApiApplication.class, args);
	}

}
