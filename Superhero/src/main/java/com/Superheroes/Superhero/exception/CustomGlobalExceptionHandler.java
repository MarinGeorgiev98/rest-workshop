package com.Superheroes.Superhero.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value = NoSuchIdException.class)
    public ResponseEntity<Object> noSuchSuperheroFound(Exception ex,HttpServletResponse resp) throws IOException {
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
    }

    //Case @Valid problem
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {

        Map<String,Object> body = new HashMap();
        body.put("timestamp",new Date());
        body.put("status",status.value());

        Map<String,String> fieldErrors = ex.getBindingResult().getFieldErrors().stream().collect(
                Collectors.toMap(FieldError::getField,FieldError::getDefaultMessage));
        body.put("errors",fieldErrors);

        return super.handleMethodArgumentNotValid(ex, headers, status, request);
    }
}
