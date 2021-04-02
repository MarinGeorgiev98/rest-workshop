package com.endava.superhero.repository;

import com.endava.superhero.model.Superhero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SuperheroRepository extends JpaRepository<Superhero, Long> {
    Optional<Superhero> getSuperheroById(Long id);
}
