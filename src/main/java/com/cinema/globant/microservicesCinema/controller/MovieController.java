package com.cinema.globant.microservicesCinema.controller;
import com.cinema.globant.microservicesCinema.dto.cast.Root;
import com.cinema.globant.microservicesCinema.dto.details.Details;
import com.cinema.globant.microservicesCinema.dto.movies.Movies;
import com.cinema.globant.microservicesCinema.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/discover")
    public ResponseEntity<List<Movies>> getDiscover(){
        return new ResponseEntity(movieService.getDiscover(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<Details>> getDetails(@PathVariable("id")Integer id){
        return new ResponseEntity(movieService.getMoviesDetails(id), HttpStatus.OK);
    }
}
