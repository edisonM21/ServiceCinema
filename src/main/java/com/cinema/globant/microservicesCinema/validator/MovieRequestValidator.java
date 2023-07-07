package com.cinema.globant.microservicesCinema.validator;

import com.cinema.globant.microservicesCinema.dto.movies.NewMovieRequestDto;
import com.cinema.globant.microservicesCinema.dto.movies.UpdateMovieRequestDto;
import com.cinema.globant.microservicesCinema.exceptions.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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
      }
      if (StringUtils.isEmpty(dto.getOverview())
          || dto.getOverview().trim().isEmpty()) {
        errors.add("Local title cannot be empty");
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

  public void validateUpdateMovieDto(UpdateMovieRequestDto dto) {
    List<String> errors = new ArrayList<>();

    // Ejercicio implementar la validación para UPDATE
    // Tareas
    // 1 Validar que el ID sí exista en BD (instanciar un repository, crear query, etc.)
    // EJERCICIO

    // 2 Validar campos como en el ejemplo anterior
    // validate dto is not null
    if (dto == null) {
      errors.add("Movie Request DTO is not ");
    } else {
      // original title
      if (StringUtils.isEmpty(dto.getOriginalTitle())
          || dto.getOriginalTitle().trim().isEmpty()) {
        errors.add("Original title cannot be empty");
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
      }
      if (StringUtils.isEmpty(dto.getOverview())
          || dto.getOverview().trim().isEmpty()) {
        errors.add("Local title cannot be empty");
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
      // EJERCICIO: Validar el resto de campos


      // If an error occurs an exception is thrown
      // with errors separated by comma
      if (!errors.isEmpty()) {
        throw new ValidationException(errors.stream().collect(Collectors.joining(", ")));
      }
    }
  }
}
