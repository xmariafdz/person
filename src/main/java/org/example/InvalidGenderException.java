package org.example;

public class InvalidGenderException extends RuntimeException{
    public InvalidGenderException(String errorMessage){
        super(errorMessage);
    }
}
