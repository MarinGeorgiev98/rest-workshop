package com.example.superHero.dto;

import com.example.superHero.model.Superhero;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
public class SuperheroDTO {

    @NotBlank(message = "First name is mandatory")
    private String firstName;

    @NotBlank(message = "last name is mandatory")
    private String lastName;

    @NotBlank(message = "superheroName is mandatory")
    private String superHeroName;

    @NotBlank(message = "email is mandatory")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
    private String email;

    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    public SuperheroDTO() {

    }

    public static Superhero superheroFromSuperHeroDTO(SuperheroDTO superHeroDTO) {
        var superhero = new Superhero();
        superhero.setSuperheroName(superHeroDTO.getSuperHeroName());
        superhero.setFirstName(superHeroDTO.getFirstName());
        superhero.setBirthday(superHeroDTO.getBirthday());
        superhero.setLastName(superHeroDTO.getLastName());
        superhero.setEmail(superHeroDTO.getEmail());
        return superhero;
    }

    public static SuperheroDTO superheroDTOFromSuperhero(Superhero superHero) {
        var superheroDTO = new SuperheroDTO();
        superheroDTO.setSuperHeroName(superHero.getSuperheroName());
        superheroDTO.setFirstName(superHero.getFirstName());
        superheroDTO.setBirthday(superHero.getBirthday());
        superheroDTO.setLastName(superHero.getLastName());
        superheroDTO.setEmail(superHero.getEmail());
        return superheroDTO;
    }
}
