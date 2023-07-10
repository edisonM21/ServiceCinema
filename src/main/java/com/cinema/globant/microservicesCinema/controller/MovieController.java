package com.cinema.globant.microservicesCinema.controller;

import com.cinema.globant.microservicesCinema.dto.BaseResponseDto;
import com.cinema.globant.microservicesCinema.dto.Result;
import com.cinema.globant.microservicesCinema.dto.movies.MovieResponseDto;
import com.cinema.globant.microservicesCinema.dto.movies.NewMovieRequestDto;
import com.cinema.globant.microservicesCinema.dto.movies.UpdateMovieRequestDto;
import com.cinema.globant.microservicesCinema.entities.Movie;
import com.cinema.globant.microservicesCinema.services.MovieService;
import com.cinema.globant.microservicesCinema.validator.MovieRequestValidator;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// Ejercicio completar Javadoc EN INGLES

@RequestMapping("/cinema/v1/movie")
public class MovieController {
  private MovieService movieService;
  private MovieRequestValidator validator;

  /**
   * Constructor Inyección de dependencias
   *
   * @param movieService
   * @param validator
   */
  public MovieController(MovieService movieService, MovieRequestValidator validator) {
    this.movieService = movieService;
    this.validator = validator;
    }

  // INICIO SERVICIOS CRUD

  /**
   * Devuelve todas las películas
   *
   * @return
   */
  @GetMapping("/getAll")
  public ResponseEntity<List<MovieResponseDto>> getAllMovies() {
    return ResponseEntity.ok(movieService.getAllList());
  }

  @GetMapping("/nowPlaying")
  public ResponseEntity<List<MovieResponseDto>> getAllMoviesPlaying() {
    return  ResponseEntity.ok(movieService.getNowPlaying());
  }

  @GetMapping("/premiere")
  public ResponseEntity<List<MovieResponseDto>> getAllPremiere() {
    return ResponseEntity.ok(movieService.getPremiere());
  }

  /**
   * Devuelve película por Id
   *
   * @param id
   * @return
   */
  @GetMapping("/get/{id}")
  public ResponseEntity<MovieResponseDto> getMovieById(@PathVariable("id") long id) {
    // si no aparece, la excepción se lanza desde el servide
    return ResponseEntity.ok(movieService.getMovieById(id));
  }

  /**
   * Crea una nueva película
   * y devuelve un objeto de respuesta genérica con el mensaje de creación
   *
   * @param movieDto
   * @return
   */
  // TODO: Por los momentos haremos el endpoint de crear una sola
  // de tal forma que sirva en el panel administrativo del frontend para que llenen un form
  // y creen la películas
  @PostMapping("/save")
  @Transactional
  public ResponseEntity<BaseResponseDto> saveMovie(@RequestBody NewMovieRequestDto movieDto) {
    // Se valida la película
    validator.validateNewMovieDto(movieDto);
    Long id = movieService.createNewMovie(movieDto);

    // se devuelve el mensaje Ok con el id de la pelicula
    BaseResponseDto response =
        BaseResponseDto
            .builder()
            .code("NEW_MOVIE")
            .message("Succesfully created movie record id=" + id)
            .timeStamp(LocalDateTime.now())
            .build();

    // cuando se crea exitosamente se devuelve un endpoint con estatus 201- CREATED
    // por lo general no se devuelve nada en el cuerpo
    // pero se puede ussar el cuerpo para devolver
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(response);
  }

  /**
   * Actualizar pelicula por ID
   * Se devuelve mensaje generico indicando que se actualizó la película
   *
   * @param id
   * @param movieDto
   * @return
   */
  @PutMapping("/update/{id}")
  public ResponseEntity<BaseResponseDto> updateMovie(@Valid @PathVariable("id") long id, @RequestBody UpdateMovieRequestDto movieDto) {
    // Se valida la película
    movieDto.setId(id);
    validator.validateUpdateMovieDto(movieDto);

    movieService.updateMovie(movieDto);

    // se devuelve el mensaje Ok con el id de la pelicula
    BaseResponseDto response =
        BaseResponseDto
            .builder()
            .code("UPDATE_MOVIE")
            .message("Succesfully updated movie record id=" + id)
            .timeStamp(LocalDateTime.now())
            .build();

    // cuando se actualiza o borra exitosamente se devuelve un endpoint con estatus 200- OK
    // por lo general no se devuelve nada en el cuerpo
    // pero se puede ussar el cuerpo para devolver
    // TODO: Otro código http usual a devolver es 204 - No Content, que indica que el request viene vacío
    // TODO: pero la operación fue exitosa, en este caso se devolvería un ResponseEntity vacío
    // TODO: Valorar con el grupo de Frontend si este enfoque es más viable.
    return ResponseEntity.ok(response);

  }

  /**
   * Borrar pelicula por ID
   * Se devuelve mensaje generico indicando que se actualizó la película
   *
   * @param id
   * @return
   */
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<BaseResponseDto> deleteMovie(@Valid @PathVariable("id") long id) {

    movieService.deleteMovie(id);

    // se devuelve el mensaje Ok con el id de la pelicula
    BaseResponseDto response =
        BaseResponseDto
            .builder()
            .code("DELETE_MOVIE")
            .message("Succesfully deleted movie record id=" + id)
            .timeStamp(LocalDateTime.now())
            .build();

    // cuando se actualiza o borra exitosamente se devuelve un endpoint con estatus 200- OK
    // por lo general no se devuelve nada en el cuerpo
    // pero se puede ussar el cuerpo para devolver
    // TODO: Otro código http usual a devolver es 204 - No Content, que indica que el request viene vacío
    // TODO: pero la operación fue exitosa, en este caso se devolvería un ResponseEntity vacío
    // TODO: Valorar con el grupo de Frontend si este enfoque es más viable.
    return ResponseEntity.ok(response);

  }


  // FIN SERVICIOS CRUD

  // INICIO SERVICIOS PENDIENTES PROXIMA ITERACION

  @GetMapping("/{region}/{release_date}/{vote_average}")
  public ResponseEntity<List<Result>> getMovieList(@PathVariable String region, @PathVariable String release_date, @PathVariable float vote_average) {
    try {
      return new ResponseEntity(movieService.getMovieList(region, release_date, vote_average), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity(e.getCause().toString(), HttpStatus.NOT_FOUND);
    }
  }




  // FIN SERVICIOS PENDIENTES PROXIMA ITERACION
}
