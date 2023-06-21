package com.cinema.globant.microservicesCinema.controller;
import com.cinema.globant.microservicesCinema.dto.details.Details;
import com.cinema.globant.microservicesCinema.dto.movies.Result;
import com.cinema.globant.microservicesCinema.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
@RequiredArgsConstructor
public class MovieController {

    @Autowired
    private  MovieService movieService;


    @GetMapping("/discover/{region}/{release_date}/{vote_average}")
    public ResponseEntity <List<Result>> getMovieList (@PathVariable String region , @PathVariable String release_date , @PathVariable float vote_average){
        return new ResponseEntity (movieService.getMovieList(region, release_date, vote_average), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity <List<Details>> getDetails (@PathVariable Integer id){
        return new ResponseEntity(movieService.getMoviesDetails(id), HttpStatus.OK);
    }
}
