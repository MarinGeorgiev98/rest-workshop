package com.endava.superhero.dto;

import com.endava.superhero.exception.validator.ValidDate;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;


import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;


@Getter
@Setter
public class SuperheroDto {
    @NotEmpty(message = "Please,enter valid input for first name.")
    private String firstName;

    @NotEmpty(message = "Please,enter valid input for first name.")
    private String lastName;

    @NotEmpty(message = "Please,enter valid input for first name.")
    private String superHeroName;

    @Pattern(regexp =  "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
    private String email;

    @ValidDate
    private LocalDate birthDate;

    public SuperheroDto() {
    }
}
