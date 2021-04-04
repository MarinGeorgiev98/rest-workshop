package com.endava.superhero.dto;

import com.endava.superhero.exception.validator.ValidDate;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;


import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.Pattern;


@Getter
@Setter
public class SuperheroDto {
    @NotEmpty(message = "First Name is required!")
    @Length(max = 50, message = "First Name must be between 3 and 50 characters.")
    private String firstName;

    @NotEmpty(message = "Last Name is required!")
    @Length(max = 50, message = "Last Name must be between 3 and 50 characters.")
    private String lastName;

    @NotEmpty(message = "Superhero Name is required!")
    @Length(max = 50, message = "Superhero Name must be between 3 and 50 characters.")
    private String superHeroName;

    @Pattern(regexp = "^(\\S+)\\@(\\S+)\\.(\\S+)$", message = "Please enter a valid Email!")
    private String email;

    @ValidDate
    private String birthDate;

    public SuperheroDto() {
    }
}
