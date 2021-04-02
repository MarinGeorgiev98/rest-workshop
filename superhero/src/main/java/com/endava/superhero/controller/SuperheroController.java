package com.endava.superhero.controller;

import com.endava.superhero.dto.SuperheroDto;
import com.endava.superhero.service.SuperheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@Validated
@RestController
@RequestMapping(value = "/v1/superheros")
public class SuperheroController {

    private SuperheroService superheroService;

    @Autowired
    public SuperheroController(SuperheroService superheroService) {
        this.superheroService = superheroService;
    }

    @GetMapping("/{id}")
    public SuperheroDto getSuperhero(@Valid @PathVariable(value="id") Long id) {
        return superheroService.getSuperhero(id);
    }

    @PostMapping(consumes = "application/json;charset=UTF-8")
    public ResponseEntity<SuperheroDto> createSuperhero(@RequestBody @Valid @Min(0) SuperheroDto superheroDto){
        try {
            return ResponseEntity.ok(superheroService.createSuperhero(superheroDto));
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
