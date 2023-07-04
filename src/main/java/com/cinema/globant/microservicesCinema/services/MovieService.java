package com.cinema.globant.microservicesCinema.services;

import com.cinema.globant.microservicesCinema.dto.Response;
import com.cinema.globant.microservicesCinema.dto.Result;
import com.cinema.globant.microservicesCinema.entities.ResultEntity;
import com.cinema.globant.microservicesCinema.repositories.RepositoryResult;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {
    @Autowired
    RepositoryResult repositoryResult;
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

    public ArrayList<ResultEntity> getAllMovies() {
        return (ArrayList<ResultEntity>) repositoryResult.findAll();
    }

    public Optional<ResultEntity> getMovieById(long id) {
        return repositoryResult.findById(id);
    }

    public List<ResultEntity> getNowPlaying(){
        return repositoryResult.findAllByNowPlaying(true);
    }

    public List<ResultEntity> getPremiere(){
        return repositoryResult.findAllByNowPlaying(false);
    }

    public List<ResultEntity> saveMovie(List<ResultEntity> movie) {
        return repositoryResult.saveAll(movie);
    }
}
