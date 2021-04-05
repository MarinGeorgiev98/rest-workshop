package com.endava.superhero.service.impl;

import com.endava.superhero.dto.SuperheroDto;
import com.endava.superhero.entity.Superhero;

import com.endava.superhero.exception.SuperheroNotFoundException;
import com.endava.superhero.repository.SuperheroRepository;
import com.endava.superhero.service.SuperheroService;
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
    public SuperheroDto createSuperhero(@Valid SuperheroDto superheroDto) {
        Superhero superhero = this.modelMapper.map(superheroDto, Superhero.class);
        return this.modelMapper.map(this.superheroRepository.save(superhero), SuperheroDto.class);
    }

    @Override
    public SuperheroDto findSuperheroById(Long id) {
        Optional<Superhero> optionalSuperhero = superheroRepository.findSuperheroById(id);
        if (optionalSuperhero.isEmpty()) {
            throw new SuperheroNotFoundException("Sorry,superhero does not exist! Try again.");
        }
        Superhero superHero = optionalSuperhero.get();
        return modelMapper.map(superHero, SuperheroDto.class);
    }


}
