package com.endava.superhero.repository;

import com.endava.superhero.entity.Superhero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SuperheroRepository extends JpaRepository<Superhero, Integer> {
    Optional<Superhero> findSuperheroById(Long id);
}
