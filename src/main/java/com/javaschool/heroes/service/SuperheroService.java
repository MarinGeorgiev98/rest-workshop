package com.javaschool.heroes.service;

import com.javaschool.heroes.exception.SuperheroNotFoundException;
import com.javaschool.heroes.model.Superhero;
import com.javaschool.heroes.model.dto.SuperheroDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface SuperheroService {

    public List<Superhero> listAll();

    public Superhero createSuperhero(Superhero superhero);

    public void delete(long id);

    Superhero getHeroById(long id) throws SuperheroNotFoundException;
}
