package com.Superheroes.Superhero.model;

import com.Superheroes.Superhero.exception.validator.NewDate;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
@Entity
@Table(
        name = "superhero",
        uniqueConstraints = @UniqueConstraint(columnNames = "id")
)
public class Superhero {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name="superhero_first_name")
    private String firstName;
    @NotEmpty
    @Column(name = "superhero_last_name")
    private String lastName;
    @NotEmpty
    @Column(name = "superhero_name")
    private String superHeroName;
    @NotEmpty
    @Column(name = "superhero_email")
    private String email;
    @NotEmpty
    @Column(name = "superhero_birthday")
    private LocalDate birthday;

}
