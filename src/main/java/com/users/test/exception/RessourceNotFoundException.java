package com.users.test.exception;

/**
 * Custom RessourceNotFoundException
 */
public class RessourceNotFoundException extends Exception{
/**
 * Constructor for RessourceNotFoundException
 * @param errorMessage
 */
    public RessourceNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
