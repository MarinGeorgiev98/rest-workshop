package com.endava.superhero.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "superheroes")
public class Superhero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (unique=true)
    private Long id;
    @NotEmpty
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty
    @Column(name = "last_name")
    private String lastName;

    @NotEmpty
    @Column(name = "superhero_name")
    private String superHeroName;

    @NotEmpty
    @Column(name = "email")
    private String email;

    @Column(name = "birth_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    public Superhero() {
    }
}
