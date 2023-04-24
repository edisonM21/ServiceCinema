package com.cinema.globant.microservicesCinema.services;

import com.cinema.globant.microservicesCinema.dto.details.Details;
import com.cinema.globant.microservicesCinema.dto.movies.Movies;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${spring.external.service.base-url}")
    private String basePath;

    private String Key="?api_key=99632828d29e9522db0e54fd17194222";



    public List<Movies> getMoviesPopular(){
        try {
            Movies response = restTemplate.getForObject(basePath+"/popular"+Key,Movies.class);
            return Arrays.asList(response);
        }catch (Exception e){
            System.out.println("Error: No se encontraron las peliculas populares"+e);
        }
        return null;
    }

    public List<Movies> getMoviesNow_Playing(){
        try {
            Movies response = restTemplate.getForObject(basePath+"/now_playing"+Key,Movies.class);
            return Arrays.asList(response);
        }catch (Exception e) {
            System.out.println("Error: No se encontraron los nuevos estrenos");
        }
        return null;
    }

    public List<Details> getMoviesDetails(Integer id){
        try {
            Details response = restTemplate.getForObject(basePath+"/"+id+Key,Details.class);
            return Arrays.asList(response);
        }catch (Exception e){
            System.out.println("Error: No se encontro la pelicula");
        }
        return null;
    }
}
