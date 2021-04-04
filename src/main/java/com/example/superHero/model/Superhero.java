package com.example.superHero.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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

    private String email;

    public Superhero(String firstName, String lastName, String superheroName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.superheroName = superheroName;
    }

    public Superhero() {

    }

    public Superhero(SuperheroDTO superheroDTO){
        this(superheroDTO.firstName, superheroDTO.lastName, superheroDTO.superHeroName);
    }

}
