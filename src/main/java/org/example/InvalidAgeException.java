package org.example;

public class InvalidAgeException extends RuntimeException{
    public InvalidAgeException(String errorMessage){
        super(errorMessage);
    }
}