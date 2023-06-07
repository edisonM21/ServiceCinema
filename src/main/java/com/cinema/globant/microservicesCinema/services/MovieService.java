package com.cinema.globant.microservicesCinema.services;
import com.cinema.globant.microservicesCinema.dto.cast.Root;
import com.cinema.globant.microservicesCinema.dto.details.Details;
import com.cinema.globant.microservicesCinema.dto.movies.Movies;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final RestTemplate restTemplate;

    @Value("${spring.external.service.base-url}")
    private String basePath;

    private String basePath2="https://api.themoviedb.org/3/discover";

    private String Key="?api_key=dd31822780bb1812b4ec7f453bc35aa8";


    public List<Movies> getDiscover(){
        try {
            Movies response = restTemplate.getForObject(basePath2+"/movie"+Key,Movies.class);
            return Arrays.asList(response);
        }catch (Exception e) {
            e.printStackTrace(System.out);
            System.out.println("Error: No se encontraron los nuevos estrenos"+e);
        }
        return null;
    }

    public List<Details> getMoviesDetails(Integer id){
        try {
            Details response = restTemplate.getForObject(basePath+"/"+id+Key,Details.class);
            return Arrays.asList(response);
        }catch (Exception e){
            e.printStackTrace(System.out);
            System.out.println("Error: No se encontro la pelicula" +e);
        }
        return null;
    }
}
