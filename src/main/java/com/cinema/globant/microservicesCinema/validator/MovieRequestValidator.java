package com.cinema.globant.microservicesCinema.validator;

import com.cinema.globant.microservicesCinema.dto.movies.NewMovieRequestDto;
import com.cinema.globant.microservicesCinema.dto.movies.UpdateMovieRequestDto;
import com.cinema.globant.microservicesCinema.exceptions.MovieNotFoundException;
import com.cinema.globant.microservicesCinema.exceptions.ValidationException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.cinema.globant.microservicesCinema.repositories.MoviesRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

/**
 * Component with validation function for movies DTO
 * <p>
 * Where an error validation occurs, a ValidationException is thrown
 */

// EJERCICIO crear funciones privadas con validaciones genéricas
// validar string nulo o no vacio
// validar entero positivo
// validar doble positivo
// validar booleano
// validar no nulo.
@Component
public class MovieRequestValidator {

    private MoviesRepository repository;

    public MovieRequestValidator(MoviesRepository repository) {
        this.repository = repository;
    }

    /**
     * The fields of the NewMovieRequestDto Dto are validated
     *
     * @param dto
     */
    public void validateNewMovieDto(NewMovieRequestDto dto) {
        List<String> errors = new ArrayList<>();

        /*
         * Se valida cada campo y si hay errores se agrega a la lista
         */
        // validate dto is not null
        if (dto == null) {
            errors.add("Movie Request DTO is not ");
        } else {
            // original title
            if (StringUtils.isEmpty(dto.getOriginalTitle())
                    || dto.getOriginalTitle().trim().isEmpty()) {
                errors.add("Original title cannot be empty");
            } else if (dto.getOriginalTitle().trim().length() > 50) {
                errors.add("The original title is too long");
            }
            // original language
            if (StringUtils.isEmpty(dto.getOriginalLanguage())
                    || dto.getOriginalLanguage().trim().isEmpty()) {
                errors.add("Original language cannot be empty");
            } else if (dto.getOriginalLanguage().trim().length() != 2) {
                errors.add("Language code must have two letters");
            }
            if (StringUtils.isEmpty(dto.getLocalTitle())
                    || dto.getLocalTitle().trim().isEmpty()) {
                errors.add("Local title cannot be empty");
            } else if (dto.getLocalTitle().trim().length() > 50) {
                errors.add("The Local title is too long");
            }
            if (StringUtils.isEmpty(dto.getOverview())
                    || dto.getOverview().trim().isEmpty()) {
                errors.add("Overview cannot be empty");
            } else if (dto.getOverview().trim().length() > 500) {
                errors.add("The Overview is too long");
            }
            if (dto.getIsForAdults() == null) {
                errors.add("isForAdults flag must be a boolean value");
            }
            if (dto.getNowPlaying() == null) {
                errors.add("nowPlaying flag must be a boolean value");
            }
            // Api Id is tested only if not null
            if (dto.getApiId() == null || dto.getApiId() < 0) {
                errors.add("Api Id must be a non-negative integer or null");
            }
        }
        // If an error occurs an exception is thrown
        // with errors separated by comma
        if (!errors.isEmpty()) {
            throw new ValidationException(errors.stream().collect(Collectors.joining(", ")));
        }
    }

    /**
     * The fields of the UpdateMovieRequestDto Dto are validated
     *
     * @param dto
     */

    public void validateUpdateMovieDto(UpdateMovieRequestDto dto) {
        List<String> errors = new ArrayList<>();

        // Ejercicio implementar la validación para UPDATE
        // Tareas
        // 1 Validar que el ID sí exista en BD (instanciar un repository, crear query, etc.)
        // EJERCICIO

        // 2 Validar campos como en el ejemplo anterior
        // validate dto is not null
        validateIdMovie(dto.getId());
        if (dto == null) {
            errors.add("Movie Request DTO is not ");
        }
        // original title
        if (StringUtils.isEmpty(dto.getOriginalTitle())
                || dto.getOriginalTitle().trim().isEmpty()) {
            errors.add("Original title cannot be empty");
        } else if (dto.getOriginalTitle().trim().length() > 50) {
            errors.add("The Original title is too long");
        }
        // original language
        if (StringUtils.isEmpty(dto.getOriginalLanguage())
                || dto.getOriginalLanguage().trim().isEmpty()) {
            errors.add("Original language cannot be empty");
        } else if (dto.getOriginalLanguage().trim().length() != 2) {
            errors.add("Original Language code must have two letters");
        }
        if (StringUtils.isEmpty(dto.getLocalTitle())
                || dto.getLocalTitle().trim().isEmpty()) {
            errors.add("Local title cannot be empty");
        } else if (dto.getLocalTitle().trim().length() > 50) {
            errors.add("The Local title is too long");
        }
        if (StringUtils.isEmpty(dto.getOverview())
                || dto.getOverview().trim().isEmpty()) {
            errors.add("Overview cannot be empty");
        } else if (dto.getOverview().trim().length() > 500) {
            errors.add("The overview is too long");
        }
        if (dto.getIsForAdults() == null) {
            errors.add("isForAdults flag must be a boolean value");
        }
        if (dto.getNowPlaying() == null) {
            errors.add("nowPlaying flag must be a boolean value");
        }
        // Api Id is tested only if not null
        if (dto.getApiId() == null || dto.getApiId() < 0) {
            errors.add("Api Id must be a non-negative integer or null");
        }
        if (dto.getPopularity() == null) {
            errors.add("Popularity cannot be null");
        } else if (dto.getPopularity() < 0.0) {
            errors.add("Popularity cannot be less than zero and is a decimal");
        }
        if (dto.getVoteAverage() == null) {
            errors.add("Vote Average cannot be null");
        } else if (dto.getVoteAverage() < 0.0) {
            errors.add("Vote average cannot be less than zero and is a decimal");
        }
        if (dto.getVoteCount() == null) {
            errors.add("VoteCount cannot be null");
        } else if (dto.getVoteCount() < 0) {
            errors.add("VoteCount cannot be less than zero");
        }
        // If an error occurs an exception is thrown
        // with errors separated by comma
        if (!errors.isEmpty()) {
            throw new ValidationException(errors.stream().collect(Collectors.joining(", ")));
        }
    }

    /**
     * It is validated if the id is negative and exists in the database
     * @param id
     */
    public void validateIdMovie(Long id) {
        List<String> errors = new ArrayList<>();
        if (id <= 0) {
            errors.add("Negative IDs or equal to zero are not allowed");
        } else if (!repository.existsById(id)) {
            throw new MovieNotFoundException(id);
        }
        if (!errors.isEmpty()) {
            throw new ValidationException(errors.stream().collect(Collectors.joining(", ")));
        }
    }
}
