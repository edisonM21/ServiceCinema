package com.cinema.globant.microservicesCinema.converte;

import com.cinema.globant.microservicesCinema.dto.movies.MovieResponseDto;
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
        return MovieResponseDto
                .builder()
                .id(m.getId())
                .originalTitle(m.getOriginalTitle())
                .originalLanguage(m.getOriginalLanguage())
                .localTitle(m.getTitle())
                .overview(m.getOverview())
                .isForAdults(m.getAdult())
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
            Movie m = movies.get();
            return MovieResponseDto
                    .builder()
                    .id(m.getId())
                    .originalTitle(m.getOriginalTitle())
                    .originalLanguage(m.getOriginalLanguage())
                    .localTitle(m.getTitle())
                    .overview(m.getOverview())
                    .isForAdults(m.getAdult())
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
