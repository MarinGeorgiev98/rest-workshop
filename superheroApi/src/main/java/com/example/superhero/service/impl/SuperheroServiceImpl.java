package com.example.superhero.service.impl;

import com.example.superhero.model.Superhero;
import com.example.superhero.repository.SuperheroRepository;
import com.example.superhero.service.SuperheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SuperheroServiceImpl implements SuperheroService {
    SuperheroRepository superheroRepository;

    @Autowired
    public SuperheroServiceImpl(SuperheroRepository superheroRepository){
        this.superheroRepository = superheroRepository;
    }


    @Override
    public Superhero addSuperhero(Superhero superhero) {
        return superheroRepository.save(superhero);

    }

    @Override
    public Optional<Superhero> getSuperheroById(int id) {
      return superheroRepository.findById(id);
    }

}
