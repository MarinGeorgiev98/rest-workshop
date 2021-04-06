package com.example.superhero.controller;

import com.example.superhero.exception.SuperheroNotFoundException;
import com.example.superhero.model.Superhero;
import com.example.superhero.model.dto.SuperheroDto;
import com.example.superhero.service.SuperheroService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.MessageFormat;
import java.util.Optional;

@Validated
@RestController
@RequestMapping(value = "/superheroes")
public class SuperheroController {

    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private SuperheroService superheroService;

    @Autowired
    public SuperheroController(SuperheroService superheroService) {
        this.superheroService = superheroService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuperheroDto> getHeroById(@PathVariable(value = "id") int id) throws SuperheroNotFoundException {
        Optional<Superhero> superHeroCandidate = superheroService.getSuperheroById(id);
        if (superHeroCandidate.isEmpty()) {
            throw new SuperheroNotFoundException(MessageFormat.format("Hero with id:{0} not exists", id));
        }
        SuperheroDto superHero = modelMapper.map(superHeroCandidate.get(), SuperheroDto.class);
        return new ResponseEntity<>(superHero, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SuperheroDto> addSuperhero(@Valid SuperheroDto superheroDto) {
        Superhero superhero = modelMapper.map(superheroDto, Superhero.class);
        SuperheroDto mappedDto = modelMapper.map(superheroService.addSuperhero(superhero), SuperheroDto.class);
        return new ResponseEntity<>(mappedDto, HttpStatus.CREATED);
    }


}
