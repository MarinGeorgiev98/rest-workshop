package com.endava.superhero.controller;

import com.endava.superhero.dto.SuperHeroDto;
import com.endava.superhero.exception.HeroNotFoundException;
import com.endava.superhero.model.SuperHero;
import com.endava.superhero.service.SuperHeroService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SuperHeroController {
    private SuperHeroService service;
    private ModelMapper modelMapper = new ModelMapper();



    @Autowired
    public SuperHeroController(SuperHeroService service) {
        this.service = service;
    }

    @PostMapping("/superheroes")
    public ResponseEntity<SuperHeroDto> createHero(@Valid @RequestBody SuperHeroDto heroDto){
        service.save(heroDto);
        return ResponseEntity.ok(heroDto);
    }

    @GetMapping("/superheroes/{id}")
    public ResponseEntity<SuperHeroDto> getById(@PathVariable Long id) throws HeroNotFoundException {
        SuperHeroDto hero = service.getById(id);

        return ResponseEntity.ok(hero);
    }




}
