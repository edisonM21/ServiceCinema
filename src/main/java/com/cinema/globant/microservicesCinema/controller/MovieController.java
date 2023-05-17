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

    @GetMapping("/now_playing")
    public ResponseEntity<List<Movies>> getNow_playing(){
        return new ResponseEntity(movieService.getMoviesNow_Playing(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<Details>> getDetails(@PathVariable("id")Integer id){
        return new ResponseEntity(movieService.getMoviesDetails(id), HttpStatus.OK);
    }
    @GetMapping("/{id}/credits")
    public ResponseEntity<List<Root>> getCast(@PathVariable("id")Integer id){
        return new ResponseEntity(movieService.getCast(id), HttpStatus.OK);
    }
}
