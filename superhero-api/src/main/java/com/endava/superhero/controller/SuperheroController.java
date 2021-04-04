package com.endava.superhero.controller;

import com.endava.superhero.dto.SuperheroDto;
import com.endava.superhero.service.SuperheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/superheroes")
public class SuperheroController {
    private final SuperheroService superheroService;

    @Autowired
    public SuperheroController(SuperheroService superheroService) {
        this.superheroService = superheroService;
    }

    @PostMapping("/create-superhero")
    public ResponseEntity<SuperheroDto> createSuperhero(@Valid @RequestBody SuperheroDto superheroDto) {
            return ResponseEntity.ok(superheroService.createSuperhero(superheroDto));
    }

    @GetMapping("/find-superhero/{id}")
    public SuperheroDto findSuperheroById(@Valid @PathVariable(value = "id") Long id){
        return this.superheroService.findSuperheroById(id);
    }
}
