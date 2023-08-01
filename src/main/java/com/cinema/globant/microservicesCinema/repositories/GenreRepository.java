package com.cinema.globant.microservicesCinema.repositories;

import com.cinema.globant.microservicesCinema.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository  extends JpaRepository<Genre, Long> {
}
