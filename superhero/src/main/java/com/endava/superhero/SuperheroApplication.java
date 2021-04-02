package com.endava.superhero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SuperheroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuperheroApplication.class, args);
	}

}
