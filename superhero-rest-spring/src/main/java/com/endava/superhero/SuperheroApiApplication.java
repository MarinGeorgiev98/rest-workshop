package com.endava.superhero;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class SuperheroApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(SuperheroApiApplication.class, args);
    }

}
