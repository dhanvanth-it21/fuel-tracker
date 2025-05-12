package com.projects.fueltracker.exception;

public class BunkBrandAlreadyExistsException extends RuntimeException{
    public BunkBrandAlreadyExistsException(String message) {
        super(message);
    }
}
