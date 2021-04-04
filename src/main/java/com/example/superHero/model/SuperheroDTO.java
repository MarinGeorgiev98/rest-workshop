package com.example.superHero.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SuperheroDTO {

    @NotBlank(message = "Name is mandatory")
    @NotNull
    String firstName;
    @NotBlank(message = "Name is mandatory")
    @NotNull
    String lastName;
    @NotBlank(message = "Name is mandatory")
    @NotNull
    String superHeroName;

    public SuperheroDTO(){

    }

    public SuperheroDTO(Superhero hero){
        this.firstName = hero.getFirstName();
        this.lastName = hero.getLastName();
        this.superHeroName = hero.getSuperheroName();
    }
}
