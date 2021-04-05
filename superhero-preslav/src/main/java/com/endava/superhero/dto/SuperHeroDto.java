package com.endava.superhero.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Date;

@Data
public class SuperHeroDto {

    @NotNull(message = "This field cannot be null")
    @NotEmpty(message = "Please provide a first name")
    private String firstName;

    @NotNull(message = "This field cannot be null")
    @NotEmpty(message = "Please provide a last name")
    private String lastName;

    @NotNull(message = "This field cannot be null")
    @NotEmpty(message = "Please provide a superhero name")
    private String SuperHeroName;

//    @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")
//    private String email;
//
//    private Date birthday;

}
