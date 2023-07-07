package com.cinema.globant.microservicesCinema.controller;

import com.cinema.globant.microservicesCinema.dto.Result;
import com.cinema.globant.microservicesCinema.entities.Movie;
import com.cinema.globant.microservicesCinema.repositories.RepositoryMovie;
import com.cinema.globant.microservicesCinema.services.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cinema/v1/movie")
@RequiredArgsConstructor
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private RepositoryMovie repositoryResult;

    @GetMapping("/{region}/{release_date}/{vote_average}")
    public ResponseEntity<List<Result>> getMovieList(@PathVariable String region, @PathVariable String release_date, @PathVariable float vote_average) {
        try {
            return new ResponseEntity(movieService.getMovieList(region, release_date, vote_average), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getCause().toString(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    private ResponseEntity<String> getAllMovies() {
        List<Movie> movie = movieService.getAllMovies();
        if (movie.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay peliculas Guardadas");
        }
        return new ResponseEntity(movie,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") long id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @GetMapping("/nowPlaying")
    private ResponseEntity<String> getAllMoviesPlaying() {
            List<Movie> movie = movieService.getNowPlaying();
            if (movie.isEmpty()) {
                return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay peliculas de nowPlaying");
            }
            return new ResponseEntity(movie,HttpStatus.OK);
    }

    @GetMapping("/premiere")
    private ResponseEntity<String> getAllMoviesPremiere() {
        List<Movie> movie = movieService.getPremiere();
        if (movie.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay peliculas de premiere");
        }
        return new ResponseEntity(movie,HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveMovie(@Valid @RequestBody List<Movie> movie) {
        try {
            return new ResponseEntity(movieService.saveMovie(movie), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Estas peliculas ya se han guardado o uno de tus campos es incorrecto");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Movie> update(@Valid @PathVariable("id") long id, @RequestBody Movie entity) {
        Optional<Movie> MoviesData = repositoryResult.findById(id);
        if (MoviesData.isPresent()) {
            Movie movies = MoviesData.get();
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
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
