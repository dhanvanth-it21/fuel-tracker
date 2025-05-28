package com.projects.fueltracker.exception;

import lombok.Getter;

@Getter
public class ResourceAlreadyExists extends RuntimeException{

    private final Object data;

    public ResourceAlreadyExists(String message, Object data) {
        super(message);
        this.data = data;
    }

}
