package com.cinema.globant.microservicesCinema.repositories;

import com.cinema.globant.microservicesCinema.entities.ResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

public interface RepositoryResult extends JpaRepository <ResultEntity,Long>{
}
