package com.cinema.globant.microservicesCinema.exceptions;

import com.cinema.globant.microservicesCinema.entities.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MovieNotFoundException extends RuntimeException{
    public MovieNotFoundException(long id){
        super("La pelicula con id = "+id+" no existe");
    }

    public MovieNotFoundException(List<Movie> movies){
        super("No hay peliculas en la base de datos");
    }
}
