package com.example.superhero.repository;


import com.example.superhero.model.Superhero;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SuperheroRepository extends JpaRepository<Superhero,Integer> {
    boolean findByEmail(final String email);
}
