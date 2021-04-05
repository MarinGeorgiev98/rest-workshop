package com.Superheroes.Superhero.service;

import com.Superheroes.Superhero.model.SuperheroDto;
import com.Superheroes.Superhero.repository.SuperheroRepo;
import mapper.SuperheroMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class SuperheroServiceImplementation  implements SuperheroService{

    private SuperheroRepo superHeroRepo;
    private SuperheroMapper superheroMapper;


    @Autowired
    public SuperheroServiceImplementation(SuperheroRepo superHeroRepo){
        this.superHeroRepo = superHeroRepo;
    }

    @Override
    public SuperheroDto getSuperheroById(Long id){
        return superheroMapper.toDto(superHeroRepo.findOneById(id));
    }

    @Override
    public Collection<SuperheroDto> getAllSuperheroes() {
        return superheroMapper.toDto(superHeroRepo.findAll());
    }
}
