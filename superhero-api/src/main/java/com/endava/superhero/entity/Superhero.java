package com.endava.superhero.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "superheroes", uniqueConstraints = {@UniqueConstraint(columnNames = {"id", "email"})})
public class Superhero extends BaseEntity{
    @NotEmpty
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty
    @Column(name = "last_name")
    private String lastName;

    @NotEmpty
    @Column(name = "super_hero_name")
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
