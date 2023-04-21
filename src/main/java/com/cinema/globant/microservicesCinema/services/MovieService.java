package com.cinema.globant.microservicesCinema.services;

import com.cinema.globant.microservicesCinema.dto.Movies;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    @Value("${spring.external.service.base-url}")
    private String basePath;

    private String Key="?api_key=99632828d29e9522db0e54fd17194222";

    RestTemplate restTemplate = new RestTemplate();


    public List<Movies> getMoviesPopular(){
        Movies response = restTemplate.getForObject(basePath+"/popular"+Key,Movies.class);
        return Arrays.asList(response);
    }

    public List<Movies> getMoviesNow_Playing(){
        Movies response = restTemplate.getForObject(basePath+"/now_playing"+Key,Movies.class);
        return Arrays.asList(response);
    }

    public List<Movies> getMoviesDetails(Integer id){
        Movies response = restTemplate.getForObject(basePath+"/"+id+Key,Movies.class);
        return Arrays.asList(response);
    }
}
