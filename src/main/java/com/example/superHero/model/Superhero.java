package com.example.superHero.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Entity
@Data
public class Superhero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Name is mandatory")
    @NotNull
    private String firstName;

    @NotBlank(message = "Name is mandatory")
    @NotNull
    private String lastName;

    @NotBlank(message = "Name is mandatory")
    @NotNull
    private String superheroName;

    @NotBlank(message = "email is mandatory")
    private String email;

    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    public Superhero() {

    }

}
