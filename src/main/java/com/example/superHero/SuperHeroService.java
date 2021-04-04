package com.example.superHero;

import com.example.superHero.model.Superhero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuperHeroService {

    SuperHeroRepository superHeroRepository;

    @Autowired
    public SuperHeroService(SuperHeroRepository superHeroRepository){
        this.superHeroRepository = superHeroRepository;
    }

    public Superhero getSuperHeroById(long id){
        return superHeroRepository.
                findById(id).orElseThrow(() -> new SuperHeroNotFoundException(id));
    }

    public Superhero createHero(Superhero superHero){
        return superHeroRepository.save(superHero);
    }

}
