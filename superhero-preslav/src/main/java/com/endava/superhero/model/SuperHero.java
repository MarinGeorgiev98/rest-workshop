package com.endava.superhero.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table(name = "superhero")
public class SuperHero {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="superhero_name")
    private String SuperHeroName;

//    @Column(name="email")
//    private String email;
//
//    @Column(name="birthday")
//    private Date birthday;

}
