package com.example.superHero;

import com.example.superHero.model.Superhero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperHeroRepository extends CrudRepository<Superhero, Long> {
}
