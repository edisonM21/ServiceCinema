package com.cinema.globant.microservicesCinema.converte;

import com.cinema.globant.microservicesCinema.dto.movies.GenreRequestDto;
import com.cinema.globant.microservicesCinema.dto.movies.MovieResponseDto;
import com.cinema.globant.microservicesCinema.entities.Genre;
import com.cinema.globant.microservicesCinema.entities.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * Converte class
 */
public class MovieConverte {

    /**
     * converter to return list of movies
     *
     * @param movies
     * @return
     */

    public List<MovieResponseDto> convertToMovieResponseDtoList(List<Movie> movies) {
        List<MovieResponseDto> result = new ArrayList<>();

        for (Movie m : movies) {
            result.add(convertToMovieResponse(m));
        }
        return result;
    }

    public MovieResponseDto convertToMovieResponse(Movie m) {
        List<GenreRequestDto> genres = new ArrayList<>();
        for (Genre g : m.getGenres()) {
            genres.add(GenreRequestDto
                    .builder()
                    .id(g.getId())
                    .name(g.getName())
                    .build());
        }

        return MovieResponseDto
                    .builder()
                    .id(m.getId())
                    .originalTitle(m.getOriginalTitle())
                    .originalLanguage(m.getOriginalLanguage())
                    .localTitle(m.getTitle())
                    .overview(m.getOverview())
                    .isForAdults(m.getAdult())
                    .genres(genres)
                    .nowPlaying(m.getNowPlaying())
                    .releaseDate(m.getReleaseDate())
                    .apiId(m.getApiId())
                    .hasVideo(m.getVideo())
                    .popularity(m.getPopularity())
                    .voteAverage(m.getVoteAverage())
                    .voteCount(m.getVoteCount())
                    .build();

    }


    /**
     * Converter to return a movie
     *
     * @param movies
     * @return
     */
    public static MovieResponseDto convertToMovieResponseDtoId(Optional<Movie> movies) {
        List<GenreRequestDto> genres = new ArrayList<>();
        for (Genre g : movies.get().getGenres()) {
            genres.add(GenreRequestDto
                    .builder()
                    .id(g.getId())
                    .name(g.getName())
                    .build());
        }
            Movie m = movies.get();
            return MovieResponseDto
                    .builder()
                    .id(m.getId())
                    .originalTitle(m.getOriginalTitle())
                    .originalLanguage(m.getOriginalLanguage())
                    .localTitle(m.getTitle())
                    .overview(m.getOverview())
                    .isForAdults(m.getAdult())
                    .genres(genres)
                    .nowPlaying(m.getNowPlaying())
                    .releaseDate(m.getReleaseDate())
                    .apiId(m.getApiId())
                    .hasVideo(m.getVideo())
                    .popularity(m.getPopularity())
                    .voteAverage(m.getVoteAverage())
                    .voteCount(m.getVoteCount())
                    .build();
    }
}
