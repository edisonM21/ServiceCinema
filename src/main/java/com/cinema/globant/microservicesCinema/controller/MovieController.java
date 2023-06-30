package com.cinema.globant.microservicesCinema.controller;
import com.cinema.globant.microservicesCinema.dto.Result;
import com.cinema.globant.microservicesCinema.entities.ResultEntity;
import com.cinema.globant.microservicesCinema.repositories.RepositoryResult;
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

    @Autowired
    private RepositoryResult repositoryResult;

    @GetMapping("/discover/{region}/{release_date}/{vote_average}")
    public ResponseEntity <List<Result>> getMovieList (@PathVariable String region , @PathVariable String release_date , @PathVariable float vote_average){
        try {
            return new ResponseEntity (movieService.getMovieList(region, release_date, vote_average), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getCause().toString(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/showAll")
    private ResponseEntity<ArrayList<ResultEntity>> getAllMovies(){
        try {
            return new ResponseEntity(movieService.getAllMovies(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getCause().toString(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/show/{id}")
    public ResponseEntity<Optional<ResultEntity>> getMovieById(@PathVariable("id")long id){
        try{
            return new ResponseEntity(movieService.getMovieById(id), HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity(e.getCause().toString(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResultEntity> update(@PathVariable("id") long id, @RequestBody ResultEntity entity){
        Optional<ResultEntity> MoviesData =  repositoryResult.findById(id);
        if (MoviesData.isPresent()) {
            ResultEntity movies = MoviesData.get();
            movies.setAdult(entity.isAdult());
            movies.setBackdrop_path(entity.getBackdrop_path());
            movies.setGenre_ids(entity.getGenre_ids());
            movies.setId(entity.getId());
            movies.setOriginal_language(entity.getOriginal_language());
            movies.setOriginal_title(entity.getOriginal_title());
            movies.setOverview(entity.getOverview());
            movies.setPopularity(entity.getPopularity());
            movies.setPoster_path(entity.getPoster_path());
            movies.setRelease_date(entity.getRelease_date());
            movies.setTitle(entity.getTitle());
            movies.setVideo(entity.isVideo());
            movies.setVote_average(entity.getVote_average());
            movies.setVote_count(entity.getVote_count());
            movies.setNowPlaying(entity.isNowPlaying());

            return new ResponseEntity<>(repositoryResult.save(movies), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/save")
    public ResponseEntity<String> saveMovie(@RequestBody List<ResultEntity> movie){
        try {
            movieService.saveMovie(movie);
            return  ResponseEntity.status(HttpStatus.CREATED).body("Peliculas Guardada Exitosamente");
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Guardando la pelicula");
        }
    }
}
