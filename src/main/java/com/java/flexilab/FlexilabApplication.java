package com.java.flexilab;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class FlexilabApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlexilabApplication.class, args);
	}

	@Bean
	public CommandLineRunner init() {
		return (args) -> {
			System.out.println("La aplicación se ha iniciado");
		};
	}
}
