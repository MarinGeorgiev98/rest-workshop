package com.Superheroes.Superhero.controller;


import com.Superheroes.Superhero.exception.NoSuchIdException;
import com.Superheroes.Superhero.model.SuperheroDto;
import com.Superheroes.Superhero.service.SuperheroService;
import com.Superheroes.Superhero.service.SuperheroServiceImplementation;
import mapper.SuperheroMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class SuperheroController {

    private SuperheroService superheroService;

    public SuperheroController(SuperheroService superheroService){
        this.superheroService = superheroService;
    }

    @GetMapping("/superhero/{id}")
    public SuperheroDto getById(@PathVariable(value = "id") Long id) throws NoSuchIdException {

        if(superheroService.getSuperheroById(id) == null){
           throw new NoSuchIdException("There is no such superhero with this id!");
        }
        return superheroService.getSuperheroById(id);
    }

    @GetMapping("/superheroes")
    public Collection<SuperheroDto> getAll(){
        return superheroService.getAllSuperheroes();
    }
}
