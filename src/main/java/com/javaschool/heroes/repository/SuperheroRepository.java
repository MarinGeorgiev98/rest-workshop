package com.javaschool.heroes.repository;

import com.javaschool.heroes.model.Superhero;
import com.javaschool.heroes.model.dto.SuperheroDto;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

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
    Optional<Superhero> findById(Long id);
}
