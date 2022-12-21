package com.users.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Controller Advice for User Controller to handle exceptions
 */
@ControllerAdvice
@ResponseBody
public class ControllerExceptionHandler {

/**
 * RessouceNotFoundException handler
 * @param ex
 * @return
 */
    @ExceptionHandler(value = RessourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String ressourceNotFoundException(RessourceNotFoundException ex){
        return ex.getMessage();
    }

/**
 * FunctionalException Handler
 * @param ex
 * @return
 */
    @ExceptionHandler(value = FunctionalException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String functionalException(FunctionalException ex){
        return ex.getMessage();
    }
}
