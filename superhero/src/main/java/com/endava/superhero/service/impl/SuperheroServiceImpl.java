package com.endava.superhero.service.impl;

import com.endava.superhero.dto.SuperheroDto;
import com.endava.superhero.exceptions.InvalidDateException;
import com.endava.superhero.exceptions.SuperheroNotFoundException;
import com.endava.superhero.mapper.SuperheroMapper;
import com.endava.superhero.model.Superhero;
import com.endava.superhero.repository.SuperheroRepository;
import com.endava.superhero.service.SuperheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class SuperheroServiceImpl implements SuperheroService {

    private SuperheroRepository superheroRepository;
    private SuperheroMapper superheroMapper;

    @Autowired
    public SuperheroServiceImpl(SuperheroRepository superheroRepository, SuperheroMapper superheroMapper) {
        this.superheroRepository = superheroRepository;
        this.superheroMapper = superheroMapper;
    }

    @Override
    public SuperheroDto createSuperhero(@Valid SuperheroDto superheroDto) {
        Superhero superhero = Optional.of(superheroDto).map(superheroMapper::toEntity).get();
                if(superhero.getBirthday().isAfter(LocalDate.now())) {
            throw new InvalidDateException("Please provide valid date." );
        }
        superhero = superheroRepository.save(superhero);
        return Optional.of(superhero).map(superheroMapper::toDto).get();
    }

    @Override
    public SuperheroDto getSuperhero (Long id) {
        return superheroMapper.toDto(superheroRepository.getSuperheroById(id).
                orElseThrow(()->new SuperheroNotFoundException("No superhero with id: " + id)));
    }
}
