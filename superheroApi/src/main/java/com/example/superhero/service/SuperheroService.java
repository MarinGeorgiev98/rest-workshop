package com.example.superhero.service;

import com.example.superhero.model.Superhero;

import java.util.Optional;

public interface SuperheroService {
    Superhero addSuperhero(Superhero superhero);
    Optional<Superhero> getSuperheroById(int id);

}
