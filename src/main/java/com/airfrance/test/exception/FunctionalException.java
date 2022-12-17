package com.airfrance.test.exception;

/**
 * Custom FunctionalException
 */
public class FunctionalException extends Exception{
/**
 * Constructor for FunctionalException
 * @param errorMessage
 */
    public FunctionalException(String errorMessage){
        super(errorMessage);
    }
}
