package com.cinema.globant.microservicesCinema.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Esta anotacion hace que si se falla por la excepcion dada
// lance el status adecuado es 400 (Bad Request) que indica que hay errores de validación
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidationException extends RuntimeException {
  public ValidationException(String errors) {
    super("Invalid request, the action could not be completed. Validation errors: " + errors, null);
  }
}
