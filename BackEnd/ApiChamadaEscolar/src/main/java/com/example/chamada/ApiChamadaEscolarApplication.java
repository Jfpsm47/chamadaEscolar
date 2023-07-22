package com.example.chamada;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class )
public class ApiChamadaEscolarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiChamadaEscolarApplication.class, args);
	}

}
