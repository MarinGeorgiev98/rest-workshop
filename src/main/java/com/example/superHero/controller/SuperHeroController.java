package com.example.superHero.controller;

import com.example.superHero.dto.SuperheroDTO;
import com.example.superHero.exception.SuperHeroNotFoundException;
import com.example.superHero.service.SuperHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/superHeroes")
public class SuperHeroController {

    private final SuperHeroService superHeroService;

    @Autowired
    public SuperHeroController(SuperHeroService superHeroService) {
        this.superHeroService = superHeroService;
    }

    @GetMapping("/hero/{id}")
    public SuperheroDTO getById(@PathVariable long id) {
        var superhero = superHeroService.getSuperHeroById(id);
        if (!superhero.isPresent()) {
            throw new SuperHeroNotFoundException(id);
        }
        return SuperheroDTO.superheroDTOFromSuperhero(superhero.get());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<SuperheroDTO> createHero(@Valid @RequestBody SuperheroDTO superHeroDTO) {
        var superhero = SuperheroDTO.superheroFromSuperHeroDTO(superHeroDTO);
        var resultSuperHero = superHeroService.createHero(superhero);
        if (resultSuperHero == null) {
            throw new SuperHeroNotFoundException(superhero.getId());
        }
        return ResponseEntity.ok(superHeroDTO);
    }
}
