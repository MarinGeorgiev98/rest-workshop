package com.endava.superhero.dao;

import com.endava.superhero.model.SuperHero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuperHeroRepository extends JpaRepository<SuperHero, Long> {


}
