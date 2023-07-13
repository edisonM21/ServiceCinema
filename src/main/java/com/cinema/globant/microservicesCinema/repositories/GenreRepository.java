package com.cinema.globant.microservicesCinema.repositories;

import com.cinema.globant.microservicesCinema.entities.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository  extends CrudRepository<Genre, Integer> {
}
