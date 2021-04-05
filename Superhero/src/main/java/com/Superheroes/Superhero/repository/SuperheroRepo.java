package com.Superheroes.Superhero.repository;


import com.Superheroes.Superhero.model.Superhero;
import com.Superheroes.Superhero.model.SuperheroDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface SuperheroRepo extends CrudRepository<Superhero,Long> {

    Collection<Superhero> findAll();
    Superhero findOneById(Long id);

}
