package com.superhero.superhero.controller;


import com.superhero.superhero.exception.InvalidSuperHeroIdException;
import com.superhero.superhero.model.Superhero;
import com.superhero.superhero.service.SuperheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/superheroes")
public class SuperheroController {
    private SuperheroService superHeroService;

    @Autowired
    public SuperheroController(SuperheroService superHeroService){
        this.superHeroService = superHeroService;
    }

    @GetMapping("/all")
    public List<Superhero> getAllSuperheroes(){
        return superHeroService.getAllSuperHeroes();
    }

    @GetMapping("/get/{id}")
    public Superhero findById(@Valid @PathVariable(value = "id") Long id) throws InvalidSuperHeroIdException {
        return superHeroService.findById(id)
                .orElseThrow(()->new InvalidSuperHeroIdException(id));
    }

    @PostMapping(value = "/create", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Superhero> addSuperHero(@Valid @RequestBody Superhero superhero){
        return ResponseEntity.ok(superHeroService.addSuperhero(superhero));
    }
}
