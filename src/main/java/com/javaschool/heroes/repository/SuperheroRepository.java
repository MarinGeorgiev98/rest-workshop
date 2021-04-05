package com.javaschool.heroes.repository;

import com.javaschool.heroes.model.Superhero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SuperheroRepository extends JpaRepository<Superhero, Long> {
    @Override
    List<Superhero> findAll();

    @Override
    Superhero save(Superhero s);

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(Superhero superhero);

    @Override
    Optional<Superhero> findById(Long id);
}
