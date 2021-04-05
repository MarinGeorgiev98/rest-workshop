package com.javaschool.heroes.model;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import java.time.LocalDate;

@Entity(name = "superhero")
public class Superhero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private long id;

    public Superhero() {
    }

    public Superhero(long id, String firstName, String lastName, String superheroName, String email, LocalDate birthDay) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.superheroName = superheroName;
        this.email = email;
        this.birthDay = birthDay;
    }

    @Column
    private String firstName;

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    @Column
    private String lastName;

    @Column(name = "superhero_name")
    private String superheroName;

    @Column
    private String email;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    @Column
    private LocalDate birthDay;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public void setSuperheroName(String superHeroName) {
        this.superheroName = superHeroName;
    }

}
