package com.endava.superhero.exception;

import com.endava.superhero.exception.HeroNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@ControllerAdvice
public class GlobalCustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(HeroNotFoundException.class)
    public void handleNotFound(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value());
    }


}
