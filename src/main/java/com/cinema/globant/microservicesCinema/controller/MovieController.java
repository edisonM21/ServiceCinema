package com.cinema.globant.microservicesCinema.controller;
import com.cinema.globant.microservicesCinema.dto.Result;
import com.cinema.globant.microservicesCinema.entities.ResultEntity;
import com.cinema.globant.microservicesCinema.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cinema/v1/movie")
@RequiredArgsConstructor
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/discover/{region}/{release_date}/{vote_average}")
    public ResponseEntity <List<Result>> getMovieList (@PathVariable String region , @PathVariable String release_date , @PathVariable float vote_average){
        try {
            return new ResponseEntity (movieService.getMovieList(region, release_date, vote_average), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getCause().toString(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    private ResponseEntity<ArrayList<ResultEntity>> getAllMovies(){
        try {
            return new ResponseEntity(movieService.getAllMovies(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getCause().toString(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<ResultEntity>> getMovieById(@PathVariable("id")long id){
        try{
            return new ResponseEntity(movieService.getMovieById(id), HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity(e.getCause().toString(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveMovie(@RequestBody List<ResultEntity> movie){
        try {
            movieService.saveMovie(movie);
            return  ResponseEntity.status(HttpStatus.CREATED).body("Pelicula Guardada Exitosamente");
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Guardando la pelicula");
        }
    }
}
