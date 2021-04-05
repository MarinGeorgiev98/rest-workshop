package com.example.superHero.service;

import com.example.superHero.model.Superhero;
import com.example.superHero.repository.SuperHeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SuperHeroService {

    private SuperHeroRepository superHeroRepository;

    @Autowired
    public SuperHeroService(SuperHeroRepository superHeroRepository) {
        this.superHeroRepository = superHeroRepository;
    }

    public Optional<Superhero> getSuperHeroById(long id) {
        return superHeroRepository.findById(id);
    }

    public Superhero createHero(Superhero superHero) {
        return superHeroRepository.save(superHero);
    }

}
