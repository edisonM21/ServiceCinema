package com.cinema.globant.microservicesCinema.exceptions;

import com.cinema.globant.microservicesCinema.entities.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MovieBadRequestException extends RuntimeException{

    public MovieBadRequestException(String errors){
        super("Request no válido, no se pudo completar la acción. Errores de validación: " + errors, null);
    }
}
