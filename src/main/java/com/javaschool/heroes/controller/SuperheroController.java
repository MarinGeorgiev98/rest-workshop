package com.javaschool.heroes.controller;

import com.javaschool.heroes.exception.SuperheroNotFoundException;
import com.javaschool.heroes.model.Superhero;
import com.javaschool.heroes.model.dto.SuperheroDto;
import com.javaschool.heroes.service.SuperheroService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/heroes")
public class SuperheroController {
    private final SuperheroService superheroService;
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public SuperheroController(SuperheroService superHeroService) {
        this.superheroService = superHeroService;
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<SuperheroDto> deleteHeroById(@PathVariable(value = "id") long id) {
        superheroService.delete(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
//        superheroService.delete(id);
    }

    @GetMapping("/hero/{id}")
    public ResponseEntity<SuperheroDto> getHeroById(@PathVariable(value = "id") long id) throws SuperheroNotFoundException {
        Superhero hero = null;
        SuperheroDto mappedDto = null;

        Optional<Superhero> optionalHero = superheroService.getHeroById(id);
        if (optionalHero.isPresent()) {
            hero = optionalHero.get();
            mappedDto = modelMapper.map(hero, SuperheroDto.class);
        } else {
            throw new SuperheroNotFoundException("The superhero does not exist!");
        }


        return ResponseEntity.ok(mappedDto);
    }


    @GetMapping("/all")
    public List<Superhero> getAll() {
        return superheroService.listAll();
    }

    @PostMapping("/add")
    public ResponseEntity<SuperheroDto> createSuperhero(@Valid @RequestBody SuperheroDto superheroDto) {
        Superhero superhero = modelMapper.map(superheroDto, Superhero.class);
        SuperheroDto mappedDto = modelMapper.map(superheroService.createSuperhero(superhero), SuperheroDto.class);
        return ResponseEntity.ok(mappedDto);
    }
}
