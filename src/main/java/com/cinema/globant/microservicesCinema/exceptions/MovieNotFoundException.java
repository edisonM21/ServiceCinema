package com.cinema.globant.microservicesCinema.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Esta anotacion hace que si se falla por la excepcion dada
// lance el status adecuado
// En este caso es una excepcion 404 no encontrado
@ResponseStatus(HttpStatus.NOT_FOUND)
public class MovieNotFoundException extends RuntimeException {
  public MovieNotFoundException (long id) {
    super("The movie with id= " + id + " does not exist", null);
  }
}
