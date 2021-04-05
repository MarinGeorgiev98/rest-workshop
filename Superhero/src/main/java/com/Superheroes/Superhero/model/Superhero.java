package com.Superheroes.Superhero.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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
    @Pattern(regexp = "/^\\S+@\\S+\\.\\S+$/")
    @Column(name = "superhero_email")
    private String email;
    @Pattern(regexp = "^(19|20)\\d\\d[-](0[1-2]|1[01])[-](0[1-9]|[12][0-9]|3[01])$")
    @Column(name = "superhero_birthday")
    private LocalDate birthday;

}
