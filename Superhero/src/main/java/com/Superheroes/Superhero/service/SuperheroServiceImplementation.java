package com.Superheroes.Superhero.service;


import com.Superheroes.Superhero.model.Superhero;
import com.Superheroes.Superhero.repository.SuperheroRepo;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class SuperheroServiceImplementation  implements SuperheroService{

    private SuperheroRepo superHeroRepo;

    @Autowired
    public SuperheroServiceImplementation(SuperheroRepo superHeroRepo){
        this.superHeroRepo = superHeroRepo;
    }

    public Superhero getSuperheroById(Long id){
        return this.superHeroRepo.findOneById(id);
    }

    @Override
    public Collection<Superhero> getAllSuperheroes() {
        return this.superHeroRepo.findAll();
    }
}
