package com.example.superHero.exception;

public class SuperHeroNotFoundException extends RuntimeException {
    public SuperHeroNotFoundException(Long id) {
        super(String.format("Superhero with Id %d not found", id));
    }
}
