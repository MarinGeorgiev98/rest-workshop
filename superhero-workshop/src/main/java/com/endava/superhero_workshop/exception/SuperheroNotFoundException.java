package com.endava.superhero_workshop.exception;

public class SuperheroNotFoundException extends RuntimeException {
    public SuperheroNotFoundException(String message) {
        super(message);
    }
}
