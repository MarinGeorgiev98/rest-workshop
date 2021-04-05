package com.endava.superhero.service;

import com.endava.superhero.dto.SuperheroDto;

import javax.validation.Valid;

public interface SuperheroService {
    SuperheroDto createSuperhero(@Valid SuperheroDto superheroDto);

    SuperheroDto findSuperheroById(Long id);
}
