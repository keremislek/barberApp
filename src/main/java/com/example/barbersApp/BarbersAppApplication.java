package com.example.barbersApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude= SecurityAutoConfiguration.class)
@ComponentScan(basePackages = {"com.example.barbersApp"})
public class BarbersAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarbersAppApplication.class, args);
	}

}
