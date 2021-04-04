package com.superhero.superhero.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages="com.superhero.superhero.repository")
public class DbConfig {
}
