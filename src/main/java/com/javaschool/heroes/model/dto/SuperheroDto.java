package com.javaschool.heroes.model.dto;

import com.javaschool.heroes.exception.validator.DateValid;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class SuperheroDto {

    public SuperheroDto() {
    }

    public SuperheroDto(String firstName, String lastName, String superheroName, String email, String birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.superheroName = superheroName;
        this.email = email;
        this.birthday = birthday;
    }

    @NotEmpty(message = "Last name should not be empty")
    private String lastName;


    @NotEmpty(message = "Superhero name should not be empty")
    private String superheroName;

    @NotEmpty(message = "First name should not be empty")
    private String firstName;

    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
    private String email;

    @DateValid
    private String birthday;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSuperheroName() {
        return superheroName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setSuperheroName(String superheroName) {
        this.superheroName = superheroName;
    }
}
