package com.example.superhero.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "superhero")
public class Superhero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotEmpty
    @NotBlank
    @Column
    private String firstName;
    @NotEmpty
    @NotBlank
    @Column
    private String lastName;
    @NotEmpty
    @NotBlank
    @Column
    private String superheroName;
    @Column(unique = true)
    private String email;
    @Column
    private String birthDate;

}
