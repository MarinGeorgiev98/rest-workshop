package com.endava.superhero.service;

import com.endava.superhero.dto.SuperheroDto;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public interface SuperheroService {

    SuperheroDto createSuperhero(@Valid SuperheroDto superHeroDto);

    SuperheroDto getSuperhero (Long id);
}
