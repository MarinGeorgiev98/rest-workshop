package com.endava.superhero.service;

import com.endava.superhero.dto.SuperHeroDto;
import com.endava.superhero.exception.HeroNotFoundException;
import com.endava.superhero.model.SuperHero;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


public interface SuperHeroService {


    public List<SuperHero> findAll();


    public SuperHeroDto save(SuperHeroDto superHero);

    SuperHeroDto getById(Long id) throws HeroNotFoundException;
}
