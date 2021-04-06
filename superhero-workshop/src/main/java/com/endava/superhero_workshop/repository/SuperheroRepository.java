package com.endava.superhero_workshop.repository;

import com.endava.superhero_workshop.model.Superhero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SuperheroRepository extends JpaRepository<Superhero,Long> {
}
