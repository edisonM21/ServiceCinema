package com.cinema.globant.microservicesCinema.services;
import com.cinema.globant.microservicesCinema.dto.details.Details;
import com.cinema.globant.microservicesCinema.dto.movies.Response;
import com.cinema.globant.microservicesCinema.dto.movies.Result;
import com.cinema.globant.microservicesCinema.mapper.MoviesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService implements IMovieService {


    private MoviesMapper moviesMapper;

    private final RestTemplate restTemplate;

    @Value("${spring.external.service.base-url}")
    private String basePathDetails;

    @Value("${spring.external.service.base-url2}")
    private String basePathDiscover;

    private String Key = "&api_key=dd31822780bb1812b4ec7f453bc35aa8";

    private String Key1 = "?api_key=dd31822780bb1812b4ec7f453bc35aa8";


    public List<Result> getMovieList (String region, String release_date, float vote_average){

        try {
            List <Result> resultList = new ArrayList<>();
            //TODO: Change response object for JSONObject
            Response response = restTemplate.getForObject(basePathDiscover+"/movie?region="+region+"&release_date.gte="+release_date+"&vote_average.gte="+vote_average+Key, Response.class);
            if (response != null) {
                resultList.addAll(response.results);
            }
            return resultList;
        }catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List <Details> getMoviesDetails (Integer id){

        try {
            Details response = restTemplate.getForObject(basePathDetails+"/"+id+Key1,Details.class);
            return Arrays.asList(response);

        }catch (Exception e){
            e.printStackTrace(System.out);

        }
        return null;
    }
}
