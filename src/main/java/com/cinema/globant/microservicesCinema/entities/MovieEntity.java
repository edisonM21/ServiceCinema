package com.cinema.globant.microservicesCinema.entities;
import com.cinema.globant.microservicesCinema.dto.movies.Result;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;

@Setter
@Getter
@Entity
@Table(name = "movies")

public class MovieEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public int page;
    public int total_pages;
    public int total_results;


    public MovieEntity(){

    }

    public MovieEntity(int page, ArrayList<Result> results, int total_pages, int total_results) {
        this.page = page;
        this.total_pages = total_pages;
        this.total_results = total_results;
    }
}
