package com.endava.rest.project.controller;

import com.endava.rest.project.dto.SuperHeroDto;
import com.endava.rest.project.exception.InvalidDateException;
import com.endava.rest.project.exception.SuperHeroNotFoundException;
import com.endava.rest.project.model.SuperHero;
import com.endava.rest.project.service.SuperHeroService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/superheroes")
public class SuperHeroController {

    private final SuperHeroService superHeroService;
    private final ModelMapper modelMapper;

    @Autowired
    public SuperHeroController(SuperHeroService superHeroService, ModelMapper modelMapper) {
        this.superHeroService = superHeroService;
        this.modelMapper = modelMapper;
    }

    @PostMapping(consumes = "application/json;charset=UTF-8")
    public ResponseEntity<SuperHeroDto> createSuperHero(@Valid @RequestBody SuperHeroDto superHeroDto) {
        if (superHeroDto.getBirthday().isAfter(LocalDate.now())) {
            throw new InvalidDateException("Not a valid date of birth.");
        }
        SuperHeroDto superHero = modelMapper.map(superHeroService.createSuperHero(superHeroDto), SuperHeroDto.class);
        return new ResponseEntity<>(superHero, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuperHeroDto> getSuperHeroInfo(@PathVariable(value = "id") @Min(1) Long id) {
        Optional<SuperHero> superHeroCandidate = superHeroService.getSuperHeroInfoById(id);
        if (superHeroCandidate.isEmpty()) {
            throw new SuperHeroNotFoundException(id);
        }
        SuperHeroDto superHero = modelMapper.map(superHeroCandidate.get(), SuperHeroDto.class);
        return new ResponseEntity<>(superHero, HttpStatus.OK);
    }
}
