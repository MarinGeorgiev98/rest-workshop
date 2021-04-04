package com.superhero.superhero.service.impl;

import com.superhero.superhero.model.Superhero;
import com.superhero.superhero.repository.SuperheroRepository;
import com.superhero.superhero.service.SuperheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuperheroServiceImpl implements SuperheroService {
    SuperheroRepository superheroRepository;

    @Autowired
    public SuperheroServiceImpl(SuperheroRepository superheroRepository){
        this.superheroRepository = superheroRepository;
    }

    @Override
    public List<Superhero> getAllSuperHeroes() {
        return superheroRepository.findAll();
    }
    @Override
    public Optional<Superhero> findById(Long id) {
        return superheroRepository.findById(id);
    }

    @Override
    public Superhero addSuperhero(Superhero superHero){
        superheroRepository.save(superHero);
        return superHero;
    }
}
