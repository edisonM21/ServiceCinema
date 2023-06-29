package com.cinema.globant.microservicesCinema.repositories;

import com.cinema.globant.microservicesCinema.entities.ResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

@Repository
public interface RepositoryResult extends JpaRepository<ResultEntity,Long>{

   // @Query("SELECT * FROM moviesResult WHERE original_language = en")
    //List<ResultEntity> findByVariable(@Param("original_language")String original_language);
}
