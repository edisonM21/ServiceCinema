package com.cinema.globant.microservicesCinema.repositories;

import com.cinema.globant.microservicesCinema.entities.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryMovies extends JpaRepository<MovieEntity, Long> {
}
