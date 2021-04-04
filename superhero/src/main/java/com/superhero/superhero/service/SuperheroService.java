package com.superhero.superhero.service;

import com.superhero.superhero.model.Superhero;

import java.util.List;
import java.util.Optional;

public interface SuperheroService {
     List<Superhero> getAllSuperHeroes();
     Optional<Superhero> findById(Long id);
     Superhero addSuperhero(Superhero superHero);
}
