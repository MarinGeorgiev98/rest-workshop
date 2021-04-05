package com.javaschool.heroes.service;

import com.javaschool.heroes.exception.SuperheroNotFoundException;
import com.javaschool.heroes.model.Superhero;
import com.javaschool.heroes.model.dto.SuperheroDto;
import com.javaschool.heroes.repository.SuperheroRepository;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuperheroServiceImpl implements SuperheroService {
    private SuperheroRepository repository;

    @Autowired
    public SuperheroServiceImpl(SuperheroRepository superheroRepository) {
        this.repository = superheroRepository;
    }

    public List<Superhero> listAll() {
        List<Superhero> allSuperheroes = repository.findAll();
        return allSuperheroes;
    }

    public Superhero createSuperhero(Superhero superhero) {

        return repository.save(superhero);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Superhero> getHeroById(long id) throws SuperheroNotFoundException {
        return repository.findById(id);
    }
}
