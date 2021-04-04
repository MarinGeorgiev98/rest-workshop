package com.endava.rest.project.exception;

public class SuperHeroNotFoundException extends RuntimeException {

    public SuperHeroNotFoundException(Long id) {
        super("Super hero with given id: " + id + ", is not present.");
    }
}
