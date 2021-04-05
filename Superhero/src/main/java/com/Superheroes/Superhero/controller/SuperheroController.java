package com.Superheroes.Superhero.controller;


import com.Superheroes.Superhero.exception.NoSuchIdException;
import com.Superheroes.Superhero.model.Superhero;
import com.Superheroes.Superhero.service.SuperheroService;
import com.Superheroes.Superhero.service.SuperheroServiceImplementation;
import org.apache.commons.logging.Log;
import org.springframework.web.bind.annotation.*;

import java.text.CollationElementIterator;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class SuperheroController {

    private SuperheroServiceImplementation superheroServiceImplementation;

    public SuperheroController(SuperheroServiceImplementation superheroServiceImplementation){
        this.superheroServiceImplementation = superheroServiceImplementation;
    }

    @GetMapping("/superhero/{id}")
    public Superhero getById(@PathVariable(value = "id") Long id) throws NoSuchIdException {

        if(superheroServiceImplementation.getSuperheroById(id) == null){
           throw new NoSuchIdException("There is no such superhero with this id!");
        }
        return superheroServiceImplementation.getSuperheroById(id);
    }

    @GetMapping("/superheroes")
    public Collection<Superhero> getAll(){
        return superheroServiceImplementation.getAllSuperheroes();
    }
}
