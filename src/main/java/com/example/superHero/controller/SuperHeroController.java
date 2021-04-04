package com.example.superHero.controller;

import com.example.superHero.SuperHeroNotFoundException;
import com.example.superHero.SuperHeroService;
import com.example.superHero.model.Superhero;
import com.example.superHero.model.SuperheroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/superHeroes")
public class SuperHeroController {

    SuperHeroService superHeroService;

    @Autowired
    public SuperHeroController(SuperHeroService superHeroService) {
        this.superHeroService = superHeroService;
    }

    @GetMapping("/hero/{id}")
    public Superhero getById(@PathVariable long id) {
        return superHeroService.getSuperHeroById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<SuperheroDTO> createHero(@Valid @RequestBody SuperheroDTO superHeroDTO) {
        Superhero superhero = new Superhero(superHeroDTO);
        superHeroService.createHero(superhero);
        return ResponseEntity.ok(superHeroDTO);
    }
}
