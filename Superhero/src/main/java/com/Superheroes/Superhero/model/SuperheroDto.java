package com.Superheroes.Superhero.model;

import com.Superheroes.Superhero.exception.validator.NewDate;
import lombok.Data;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
public class SuperheroDto {

    @NotEmpty(message = "Provide superhero first name")
    private String firstName;
    @NotEmpty(message = "Provide superhero last name")
    private String lastName;
    @NotEmpty(message = "Provide superhero name")
    private String superHeroName;
    @Pattern(regexp = "/^\\S+@\\S+\\.\\S+$/")
    private String email;
    @Future
    @Past
    @NewDate(current = "1900-01-01")
    private LocalDate birthday;

}
