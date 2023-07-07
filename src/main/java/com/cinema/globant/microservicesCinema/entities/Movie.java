package com.cinema.globant.microservicesCinema.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@Entity
@Table(name = "moviesResult")
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    public long movie_id;

    @Column(nullable = false)
    public boolean adult;

    @NotEmpty
    @Column(nullable= false)
    public String backdrop_path;

    @NotNull
    @Column(nullable= false)
    public ArrayList<Integer> genre_ids;

    @Min(value = 1)
    @Column(name = "id_api", nullable= false, unique = true)
    public int id;

    @NotEmpty
    @Column(nullable= false, length = 2)
    public String original_language;

    @NotEmpty
    @Column(nullable= false)
    public String original_title;

    @NotEmpty
    @Column(nullable= false,columnDefinition="text")
    public String overview;

    @DecimalMin(value = "0.1")
    @Column(nullable= false)
    public double popularity;

    @NotEmpty
    @Column(nullable= false)
    public String poster_path;

    @NotEmpty
    @Column(name = "date_movie", nullable= false)
    public String release_date;

    @NotEmpty
    @Column(nullable= false)
    public String title;

    @Column(nullable= false)
    public boolean video;

    @DecimalMin(value = "0.1")
    @Column(nullable= false)
    public double vote_average;

    @Min(value = 0)
    @Column(nullable= false)
    public int vote_count;

    @Column(nullable= false)
    public boolean nowPlaying = false;

}
