package com.endava.rest.project.service;

import com.endava.rest.project.dto.SuperHeroDto;
import com.endava.rest.project.model.SuperHero;

import javax.validation.Valid;
import java.util.Optional;

public interface SuperHeroService {

    SuperHero createSuperHero(@Valid SuperHeroDto superHeroDto);

    Optional<SuperHero> getSuperHeroInfoById(Long id);
}
