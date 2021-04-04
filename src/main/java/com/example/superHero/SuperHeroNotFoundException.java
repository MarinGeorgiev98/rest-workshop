package com.example.superHero;

import javax.swing.*;

public class SuperHeroNotFoundException extends RuntimeException {
    SuperHeroNotFoundException(Long id){
        super(String.format("Superhero with Id %d not found", id));
    }
}
