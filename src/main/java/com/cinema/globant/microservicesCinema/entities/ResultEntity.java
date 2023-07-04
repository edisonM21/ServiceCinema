package com.cinema.globant.microservicesCinema.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    public long movie;
    @NotNull
    public boolean adult;
    @NotNull
    @NotBlank
    public String backdrop_path;
    @NotNull
    public ArrayList<Integer> genre_ids;
    @NotNull
    public int id;
    @NotNull
    @NotBlank
    public String original_language;
    @NotNull
    @NotBlank
    public String original_title;
    @NotNull
    @NotBlank
    @Column(length = 1000)
    public String overview;
    @NotNull
    public double popularity;
    @NotNull
    @NotBlank
    public String poster_path;
    @NotNull
    @NotBlank
    public String release_date;
    @NotNull
    @NotBlank
    public String title;
    @NotNull
    public boolean video;
    @NotNull
    public double vote_average;
    @NotNull
    public int vote_count;
    @NotNull
    public boolean nowPlaying = false;

    public ResultEntity() {

    }

    public ResultEntity(long movie, boolean adult, String backdrop_path, ArrayList<Integer> genre_ids, int id, String original_language, String original_title, String overview, double popularity, String poster_path, String release_date, String title, boolean video, double vote_average, int vote_count, boolean nowPlaying) {
        this.movie = movie;
        this.adult = adult;
        this.backdrop_path = backdrop_path;
        this.genre_ids = genre_ids;
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
