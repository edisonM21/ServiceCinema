package com.cinema.globant.microservicesCinema.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "movies")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Movie {
    // Convención
    // Los atributos de las clases siempre en CAMEL CASE
    // nombre de las columnas y tablas de BD siempre SNAKE_CASE, como prefijo el nombre de la tabla
    // En los tipos base es preferible usar los envoltorios objeto, para manejar nulos adecuadamente
    // Ejemplo usar
    // Integer en vez de int
    // Double en vez de double
    // Boolean en vez de boolean, etc.

    /*
     * En la anotación column, el valor nullable = false indica que en BD no pueden haber nulos
     * si no está por defecto nullable = true y el campo puede tener valores nulos
     *
     * Esto se puede hacer también en la anotación table a través del atributo uniqueConstraints
     */

    // database Id primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name="movie_id")
    private Long id;

    // is the movie only for adults
    @Column(name="movie_adult", nullable = false)
    private Boolean adult = false;

    // poster image path
    @Column(name="movie_backdrop_path")
    private String backdropPath;

    // id in external API
    @Column(name="movie_api_id", nullable = false)
    private Integer apiId = 0;

    // original language of the movie
    @Column(name="movie_original_language", nullable = false, length = 2)
    private String originalLanguage;

    // original title of the movie
    @Column(name="movie_original_title", nullable = false, length = 200)
    private String originalTitle;

    // ColumnDefinition es si quiere forzar un tipo específico del motor sql
    // en este caso especifico tipo TEXT de mySQL que son texto de hasta 65Kb
    // overview of the movie
    @Column(name="movie_overview", nullable = false,  columnDefinition = "text")
    private String overview;

    // popularity of the movie
    private Double popularity = 0.0D;

    // path of the poster image
    @Column(name="movie_poster_path", nullable = false)
    private String posterPath;

    /*
    *  Siempre los titulos deben setearse del tipo que es
    * Un tipo fecha va como fecha
    * */
    // release date of the movie
    // Anotación temporal quizás necesaria en versiones anteriores
    // es opcional pero da una marca de qué tipo de tiempo se almacena
    // release date or null if it not now
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="movie_release_date", columnDefinition = "TIMESTAMP")
    private LocalDateTime releaseDate;

    // title of the movie in local language
    @Column(name="movie_title", nullable = false, length = 200)
    private String title;

    // does the movie has video version?
    @Column(name="movie_video", nullable = false)
    private Boolean  video = false;

    // average of user voting
    @Column(name="movie_vote_average", nullable = false)
    private Double voteAverage = 0.0;

    // total votes
    @Column(name="movie_vote_count", nullable = false)
    private Integer voteCount = 0;

    // is the movie currently in theaters?
    @Column(name="movie_now_playing", nullable = false)
    private Boolean nowPlaying = false;
}
