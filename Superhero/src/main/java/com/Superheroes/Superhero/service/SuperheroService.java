package com.Superheroes.Superhero.service;

import com.Superheroes.Superhero.model.Superhero;
import com.Superheroes.Superhero.model.SuperheroDto;

import java.util.Collection;

public interface SuperheroService {

    SuperheroDto getSuperheroById(Long id);
    Collection<SuperheroDto> getAllSuperheroes();
}
