package com.endava.rest.project.service.impl;

import com.endava.rest.project.dto.SuperHeroDto;
import com.endava.rest.project.model.SuperHero;
import com.endava.rest.project.repository.SuperHeroRepository;
import com.endava.rest.project.service.SuperHeroService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;

@Service
public class SuperHeroServiceImpl implements SuperHeroService {

    private final SuperHeroRepository superheroRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public SuperHeroServiceImpl(SuperHeroRepository superheroRepository, ModelMapper modelMapper) {
        this.superheroRepository = superheroRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public SuperHero createSuperHero(@Valid SuperHeroDto superHeroDto) {
        SuperHero superHero = modelMapper.map(superHeroDto, SuperHero.class);
        return superheroRepository.save(superHero);
    }

    @Override
    public Optional<SuperHero> getSuperHeroInfoById(Long id) {
        return superheroRepository.findById(id);
    }
}
