package com.endava.superhero_workshop.controller;

import com.endava.superhero_workshop.dto.SuperheroDto;
import com.endava.superhero_workshop.exception.InvalidDateException;
import com.endava.superhero_workshop.exception.SuperheroNotFoundException;
import com.endava.superhero_workshop.model.Superhero;
import com.endava.superhero_workshop.service.SuperheroService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Optional;

@RestController
public class SuperheroController {
    private final SuperheroService superheroService;
    private final ModelMapper modelMapper;

    @Autowired
    public SuperheroController(SuperheroService superheroService,ModelMapper modelMapper) {

        this.superheroService = superheroService;
        this.modelMapper= modelMapper;
    }

    @PostMapping("/create")
    public ResponseEntity<SuperheroDto> createSuperhero(@Valid @RequestBody SuperheroDto superheroDto) {
        if (superheroDto.getBirthDate().isAfter(LocalDate.now())) {
            throw new InvalidDateException("invalid date of birth.");
        }
        return new ResponseEntity<>(modelMapper.map(superheroService.createSuperhero(superheroDto), SuperheroDto.class), HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<SuperheroDto> getSuperheroById(@Valid @PathVariable(value = "id") Long id) {
        Optional<Superhero> optionalSuperhero = superheroService.getSuperheroById(id);
        if (optionalSuperhero.isEmpty()) {
            throw new SuperheroNotFoundException("Sorry,superhero with " + id + " does not exist!");
        }
        return new ResponseEntity<>(modelMapper.map(optionalSuperhero.get(), SuperheroDto.class), HttpStatus.OK);
    }
}
