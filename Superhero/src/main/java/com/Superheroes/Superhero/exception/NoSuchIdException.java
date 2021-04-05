package com.Superheroes.Superhero.exception;

import javax.validation.Valid;

@Valid
public class NoSuchIdException extends Exception{
    public  NoSuchIdException(String errorMessage){
        super(errorMessage);
    }
}
