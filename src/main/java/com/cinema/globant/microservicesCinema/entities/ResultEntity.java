package com.cinema.globant.microservicesCinema.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;

@Getter
@Setter
@Entity
@Table(name = "moviesResult")
public class ResultEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    public long movie;
    public boolean adult;
    public String backdrop_path;
    public int id;
    public String original_language;
    public String original_title;
    public String overview;
    public double popularity;
    public String poster_path;
    public String release_date;
    public String title;
    public boolean video;
    public double vote_average;
    public int vote_count;
    public boolean nowPlaying = false;

    public ResultEntity(){

    }

    public ResultEntity(long movie, boolean adult, String backdrop_path, int id, String original_language, String original_title, String overview, double popularity, String poster_path, String release_date, String title, boolean video, double vote_average, int vote_count, boolean nowPlaying) {
        this.movie = movie;
        this.adult = adult;
        this.backdrop_path = backdrop_path;
        this.id = id;
        this.original_language = original_language;
        this.original_title = original_title;
        this.overview = overview;
        this.popularity = popularity;
        this.poster_path = poster_path;
        this.release_date = release_date;
        this.title = title;
        this.video = video;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
        this.nowPlaying = nowPlaying;
    }
}
