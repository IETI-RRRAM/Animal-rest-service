package edu.eci.agronomo.animal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AnimalNotFoundException extends ResponseStatusException {

    public AnimalNotFoundException(String id) {
        super(HttpStatus.NOT_FOUND, "Animal with ID: " + id + " not found");
    }
}
