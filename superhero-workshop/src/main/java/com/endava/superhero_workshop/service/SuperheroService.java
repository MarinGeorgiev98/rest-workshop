package com.endava.superhero_workshop.service;

import com.endava.superhero_workshop.dto.SuperheroDto;
import com.endava.superhero_workshop.model.Superhero;

import javax.validation.Valid;
import java.util.Optional;

public interface SuperheroService {
    Superhero createSuperhero(@Valid SuperheroDto superheroDto);

    Optional<Superhero> getSuperheroById(Long id);
}
