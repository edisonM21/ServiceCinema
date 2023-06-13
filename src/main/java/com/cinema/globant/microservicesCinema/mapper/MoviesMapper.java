package com.cinema.globant.microservicesCinema.mapper;


import com.cinema.globant.microservicesCinema.dto.movies.Result;
import com.cinema.globant.microservicesCinema.entities.MovieEntity;
import com.cinema.globant.microservicesCinema.entities.ResultEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface MoviesMapper {

    Result resultToMovie(ResultEntity resultEntity);

    MovieEntity movieToResult(Result result);
}
