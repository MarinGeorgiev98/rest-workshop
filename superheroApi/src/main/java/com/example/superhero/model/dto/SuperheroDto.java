package com.example.superhero.model.dto;

import com.example.superhero.exception.validator.ValidDate;
import com.example.superhero.exception.validator.ValidEmail;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class SuperheroDto {

    @NotEmpty(message = "First name cannot be empty.")
    private String firstName;
    @NotEmpty(message = "Last name cannot be empty.")
    private String lastName;
    @NotEmpty(message = "Superhero name cannot be empty.")
    private String superheroName;
    @NotEmpty(message = "Email cannot be empty.")
    @ValidEmail
    private String email;
    @NotNull(message = "Date of birth cannot be empty.")
    @ValidDate
    private String birthDate;

}
