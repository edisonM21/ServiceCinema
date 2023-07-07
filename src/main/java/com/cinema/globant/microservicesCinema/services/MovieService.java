package com.cinema.globant.microservicesCinema.services;

import com.cinema.globant.microservicesCinema.dto.Response;
import com.cinema.globant.microservicesCinema.dto.Result;
import com.cinema.globant.microservicesCinema.entities.Movie;
import com.cinema.globant.microservicesCinema.exceptions.MovieNotFoundException;
import com.cinema.globant.microservicesCinema.repositories.RepositoryMovie;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    @Autowired
    RepositoryMovie repositoryMovie;
    @Autowired
    private RestTemplate restTemplate;

    @Value("${spring.external.service.base-url2}")
    private String basePathDiscover;

    @Value("${spring.external.service.base-key}")
    private String Key;


    public List<Result> getMovieList(String region, String release_date, float vote_average) {

        List<Result> resultList = new ArrayList<>();
        Response response = restTemplate.getForObject(basePathDiscover + "/movie?region=" + region + "&release_date.gte=" + release_date + "&vote_average.gte=" + vote_average + Key, Response.class);
        if (response != null) {
            resultList.addAll(response.results);
        }
        return resultList;
    }

    public List<Movie> getAllMovies() {
        return repositoryMovie.findAll();
    }

    public Movie getMovieById(long id) {
        return repositoryMovie
                .findById(id)
                .orElseThrow(()-> new MovieNotFoundException(id));
    }

    public List<Movie> getNowPlaying(){
        return repositoryMovie.findAllByNowPlaying(true);
    }

    public List<Movie> getPremiere(){
        return repositoryMovie.findAllByNowPlaying(false);
    }

    public List<Movie> saveMovie(List<Movie> movie) {
        return repositoryMovie.saveAll(movie);
    }
}
