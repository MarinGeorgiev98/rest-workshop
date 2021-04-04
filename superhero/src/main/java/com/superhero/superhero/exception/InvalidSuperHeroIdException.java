package com.superhero.superhero.exception;

public class InvalidSuperHeroIdException extends Exception{
    public InvalidSuperHeroIdException(Long id) {
        super("Superhero with id:" + id + " doesn't exist");
    }
}
