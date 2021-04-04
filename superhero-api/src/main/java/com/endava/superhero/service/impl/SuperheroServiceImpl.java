package com.endava.superhero.service.impl;

import com.endava.superhero.dto.SuperheroDto;
import com.endava.superhero.entity.Superhero;
import com.endava.superhero.exception.InvalidDateException;
import com.endava.superhero.exception.SuperheroNotFoundException;
import com.endava.superhero.repository.SuperheroRepository;
import com.endava.superhero.service.SuperheroService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
        Superhero superhero = this.modelMapper
                .map(superheroDto, Superhero.class);

        if (LocalDate.parse(superheroDto.getBirthDate()).isBefore(LocalDate.now())){
            superhero.setBirthDate(LocalDate.parse(superheroDto.getBirthDate()));
        }else {
            throw new InvalidDateException("Please enter a valid Birth Date!");
        }


        return this.modelMapper
                .map(this.superheroRepository.save(superhero), SuperheroDto.class);
    }

    @Override
    public SuperheroDto findSuperheroById(Long id) {
        return this.superheroRepository
                .findSuperheroById(id)
                .map(superhero -> {
                    SuperheroDto superheroDto = this.modelMapper
                            .map(superhero, SuperheroDto.class);

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    superheroDto.setBirthDate(superhero.getBirthDate().format(formatter));

                    return superheroDto;
                })
                .orElseThrow(() -> new SuperheroNotFoundException("Superhero not found!"));
    }
}
