package com.Superheroes.Superhero.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.Superheroes.Superhero.repository")
public class DbConfiguration {

}
