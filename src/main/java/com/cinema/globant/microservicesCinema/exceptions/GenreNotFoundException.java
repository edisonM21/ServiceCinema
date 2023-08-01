package com.cinema.globant.microservicesCinema.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Http not found response class
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class GenreNotFoundException extends RuntimeException {
    public GenreNotFoundException(long id) {
        super("The Genre with id= " + id + " does not exist", null);
    }
}
