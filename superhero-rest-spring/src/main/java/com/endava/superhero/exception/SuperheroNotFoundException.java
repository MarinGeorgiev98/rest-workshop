package com.endava.superhero.exception;

public class SuperheroNotFoundException extends RuntimeException {
    public SuperheroNotFoundException(String message) {
        super(message);
    }
}