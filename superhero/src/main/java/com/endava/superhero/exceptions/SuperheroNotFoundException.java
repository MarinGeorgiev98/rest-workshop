package com.endava.superhero.exceptions;

public class SuperheroNotFoundException extends RuntimeException {

    public SuperheroNotFoundException(String errorMessage) {
        super(errorMessage);
    }


}
