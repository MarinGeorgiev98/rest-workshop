package com.endava.superhero_workshop.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;


@Getter
@Setter
public class SuperheroDto {
    @NotBlank(message = "Please,enter first name.")
    private String firstName;

    @NotBlank(message = "Please,enter last name.")
    private String lastName;

    @NotBlank(message = "Please,enter superhero name.")
    private String superheroName;

    @Pattern(regexp="^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

}
