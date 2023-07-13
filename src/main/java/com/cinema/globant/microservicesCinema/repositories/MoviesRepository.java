package com.cinema.globant.microservicesCinema.repositories;

import com.cinema.globant.microservicesCinema.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoviesRepository extends JpaRepository<Movie,Long>{
    List<Movie> findAllByNowPlaying(boolean nowPlaying);
}
