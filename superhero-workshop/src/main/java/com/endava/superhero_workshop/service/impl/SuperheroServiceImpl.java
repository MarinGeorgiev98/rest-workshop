package com.endava.superhero_workshop.service.impl;

import com.endava.superhero_workshop.dto.SuperheroDto;
import com.endava.superhero_workshop.model.Superhero;

import com.endava.superhero_workshop.repository.SuperheroRepository;
import com.endava.superhero_workshop.service.SuperheroService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;

@Service
public class SuperheroServiceImpl implements SuperheroService {
    private final SuperheroRepository superheroRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public SuperheroServiceImpl(SuperheroRepository superheroRepository, ModelMapper modelMapper) {
        this.superheroRepository = superheroRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Superhero createSuperhero(@Valid SuperheroDto superheroDto) {
        Superhero superhero = this.modelMapper.map(superheroDto, Superhero.class);
        return superheroRepository.save(superhero);
    }

    @Override
    public Optional<Superhero> getSuperheroById(Long id) {
       return superheroRepository.findById(id);
    }


}
