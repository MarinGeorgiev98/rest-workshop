package com.endava.superhero.service;


import com.endava.superhero.dao.SuperHeroRepository;
import com.endava.superhero.dto.SuperHeroDto;
import com.endava.superhero.exception.HeroNotFoundException;
import com.endava.superhero.model.SuperHero;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class SuperHeroServiceImpl implements SuperHeroService {
    private SuperHeroRepository repo;
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public SuperHeroServiceImpl(SuperHeroRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<SuperHero> findAll() {
        return repo.findAll();
    }

    @Override
    public SuperHeroDto save(SuperHeroDto dto) {
        SuperHero hero = modelMapper.map(dto, SuperHero.class);
        repo.save(hero);
        return dto;
    }

    @Override
    public SuperHeroDto getById(Long id) throws HeroNotFoundException {
        Optional<SuperHero> result = repo.findById(id);
        SuperHero hero = null;
        SuperHeroDto heroDto = null;

        if (result.isPresent()) {
            hero = result.get();
            heroDto = modelMapper.map(hero, SuperHeroDto.class);
        }
        else{
            throw new HeroNotFoundException("No hero with id: "+id);
        }

        return heroDto;
    }

}
