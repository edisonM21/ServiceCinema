package com.cinema.globant.microservicesCinema.services;

import com.cinema.globant.microservicesCinema.dto.Response;
import com.cinema.globant.microservicesCinema.dto.Result;
import com.cinema.globant.microservicesCinema.dto.movies.MovieResponseDto;
import com.cinema.globant.microservicesCinema.dto.movies.NewMovieRequestDto;
import com.cinema.globant.microservicesCinema.dto.movies.UpdateMovieRequestDto;
import com.cinema.globant.microservicesCinema.entities.Movie;
import com.cinema.globant.microservicesCinema.exceptions.MovieNotFoundException;
import com.cinema.globant.microservicesCinema.repositories.MoviesRepository;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


/**
 * Clase servicio para las operaciones CRUD de películas
 */
@Service
// Ejercicio completar Javadoc EN INGLES

public class MovieService {

  private final MoviesRepository moviesRepository;
  private final RestTemplate restTemplate;
  private final String basePathDiscover;
  private final String key;

  /**
   * Constructor Inyección de dependencias
   *
   * @param moviesRepository
   * @param restTemplate
   * @param basePathDiscover
   * @param key
   */
  public MovieService(
      MoviesRepository moviesRepository,
      RestTemplate restTemplate,
      @Value("${spring.external.service.base-url2}") String basePathDiscover,
      @Value("${spring.external.service.base-key}") String key) {
    this.moviesRepository = moviesRepository;
    this.restTemplate = restTemplate;
    this.basePathDiscover = basePathDiscover;
    this.key = key;
  }

  // INICIO SERVICIOS CRUD

  /**
   * buscar pelicula por ID
   *
   * @param id
   * @return
   */
  public MovieResponseDto getMovieById(long id) {
    // Forma básica usando condicionales
    // EJERCICIO crear convertidor
    Optional<Movie> optMovie = moviesRepository.findById(id);

    if (optMovie.isPresent()) {
      Movie m = optMovie.get();
      return
          MovieResponseDto
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

    } else {
      throw new MovieNotFoundException(id);
    }
    // TODO: Estudiar el tema funcional en java y comprender el  funcionamiento
//    return moviesRepository
//        .findById(id)
//        .orElseThrow(() -> new MovieNotFoundException(id));
  }


  /**
   * Devuelve todas las películas sin filtros
   *
   * @return
   */
  public List<MovieResponseDto> getAllList() {
    // Forma básica con ciclos
    // buscar lista de BD
    List<Movie> movies =  moviesRepository.findAll();
    // armar la lista convertida
    List<MovieResponseDto> result = new ArrayList<>();
    // se itera y se crea lista
    for (Movie m : movies) {
      // Ejercicio: Usar convertidor
      result.add(MovieResponseDto
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
          .build());
    }
    return result;


    // Forma funcional

//    return moviesRepository
//        .findAll()
//        .stream()
//        .map(m ->  MovieResponseDto
//            .builder()
//            .id(m.getId())
//            .originalTitle(m.getOriginalTitle())
//            .originalLanguage(m.getOriginalLanguage())
//            .localTitle(m.getTitle())
//            .overview(m.getOverview())
//            .isForAdults(m.getAdult())
//            .nowPlaying(m.getNowPlaying())
//            .releaseDate(m.getReleaseDate())
//            .apiId(m.getApiId())
//            .hasVideo(m.getVideo())
//            .popularity(m.getPopularity())
//            .voteAverage(m.getVoteAverage())
//            .voteCount(m.getVoteCount())
//            .build())
//        .collect(Collectors.toList());
  }


  // TODO: Tiene sentido el flag del API para saber si la película está siendo proyecteada?
  // TODO: En el modelo de BD debe crearse entidades que reflejen la proyección de una película
  // TODO: y si está en cartelera o no, podría ser con fechas de entrada y salida de cartelera de la película
  public List<MovieResponseDto> getNowPlaying() {
    List<Movie> movies = moviesRepository.findAllByNowPlaying(true);
    // armar la lista convertida
    List<MovieResponseDto> result = new ArrayList<>();
    // se itera y se crea lista
    for (Movie m : movies) {
      // Ejercicio: Usar convertidor
      result.add(MovieResponseDto
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
              .build());

    }
    return result;
  }

  // TODO: Tiene sentido el flag del API para saber si la película está en estreno?
  // TODO: En el modelo de BD debe crearse entidades que reflejen la proyección de una película
  // TODO: y si está en cartelera o no, podría ser con fechas de entrada y salida de cartelera de la película

  public List<MovieResponseDto> getPremiere() {
    List<Movie> movies = moviesRepository.findAllByNowPlaying(false);
    // armar la lista convertida
    List<MovieResponseDto> result = new ArrayList<>();
    // se itera y se crea lista
    for (Movie m : movies) {
      // Ejercicio: Usar convertidor
      result.add(MovieResponseDto
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
              .build());

    }
    return result;
  }

  /**
   * Crea una nueva película
   * <p>
   * Se asume el dto ya válido y no nulo
   *
   * @param dto
   * @return Id de la nueva película creada en BD
   */
  @Transactional
  public Long createNewMovie(NewMovieRequestDto dto) {
    // conversión
    // EJERCICIO Crear convertidor con MapStruct
    Movie m = Movie
        .builder()
        .adult(dto.getIsForAdults())
        .apiId(dto.getApiId())
        .originalLanguage(dto.getOriginalLanguage().trim())
        .originalTitle(dto.getOriginalTitle().trim())
        .title(dto.getLocalTitle().trim()) // TODO: Pensar esquema para llevar a títulos a varios idiomas
        .overview(dto.getOverview().trim())
        .nowPlaying(dto.getNowPlaying())
        .releaseDate(dto.getReleaseDate())

        .backdropPath("")  // TODO: Revisar si realmente este campo tiene sentido
        .posterPath("")  // TODO: Revisar si realmente este campo tiene sentido
        .video(false) //TODO: Revisar si realmente este campo tiene sentido, mejor se'ria una URL del trailer en youtube, por ejemplo

        //TODO: Los temas de encuesta y puntuación deben modelarse a entidad aparte
        .voteAverage(0.0D)
        .voteCount(0)
        .popularity(0.0)
        .build();

    // save to DB
    moviesRepository.save(m);
    return m.getId();
  }

  /**
   * Actualiza una película existente
   * <p>
   * Se asume el dto ya válido y no nulo
   *
   * @param dto
   * @return Id de la nueva película actualizada en BD que es el mismo del DTO
   */
  @Transactional
  public Long updateMovie(UpdateMovieRequestDto dto) {
    // EJERCICIO: Hacer este lógica pero con un Query UPDATE escrito con JPQL en el repository
    // traer película de BD para actualizar sus campos
    // si no existe lanza excepción
    // buscar en BD si no existe lanza excepción
    Long id = dto.getId();
    Movie m = moviesRepository
        .findById(id)
        .orElseThrow(() -> new MovieNotFoundException(id));

    // Actualizar los campos
    // ya se supone que el dto es válido
    // se modifica todos los campos menos ID
    m.setAdult(dto.getIsForAdults());
    m.setApiId(dto.getApiId());
    m.setOriginalLanguage(dto.getOriginalLanguage().trim());
    m.setOriginalTitle(dto.getOriginalTitle().trim());
    m.setTitle(dto.getLocalTitle().trim()); // TODO: Pensar esquema para llevar a títulos a varios idiomas
    m.setOverview(dto.getOverview().trim());
    m.setNowPlaying(dto.getNowPlaying());
    m.setReleaseDate(dto.getReleaseDate());

    m.setBackdropPath("");  // TODO: Revisar si realmente este campo tiene sentido
    m.setPosterPath("");  // TODO: Revisar si realmente este campo tiene sentido
    m.setVideo(false); //TODO: Revisar si realmente este campo tiene sentido, mejor se'ria una URL del trailer en youtube, por ejemplo

    //TODO: Los temas de encuesta y puntuación deben modelarse a entidad aparte
    m.setVoteAverage(0.0D);
    m.setVoteCount(0);
    m.setPopularity(0.0);

    // TODO: Ver si es realmente necesario devolver el ID
    return id;
  }

  /**
   * Elimina película por ID
   *
   * @param id
   * @return
   */
  // TODO: Implementar borrado lógico, es decir que no se borre el registro de BD, sino haya un flag deleted y el
  // TODO: borrado sería actualizar el flag sin eliminar el dato de tabla
  @Transactional
  public Long deleteMovie(Long id) {
    // TODO: Ver si es realmente necesario devolver el ID
    moviesRepository.deleteById(id);
    return id;
  }

  // FIN SERVICIOS CRUD

  // INICIO IMPLEMENTAR LUEGO

  // Ejercicio: Investigar cómo se implementa llamado a API http con librería Netflix Feign
  public List<Result> getMovieList(String region, String release_date, float vote_average) {

    List<Result> resultList = new ArrayList<>();
    // TODO: guardar la URL como un string con placeholder eun property y luego armarla con parámetros
    // TODO: usar  el objeto URL o algún template para armar la URL de forma parametrizada
    Response response = restTemplate.getForObject(basePathDiscover + "/movie?region=" + region + "&release_date.gte=" + release_date + "&vote_average.gte=" + vote_average + key, Response.class);
    if (response != null) {
      resultList.addAll(response.results);

    }

    // TODO: El servicio DEBE devolver lista de Moviw
    // Ejercicio Crear convertidor Result --> Movie
    // Crear ciclo con map, usando el convertidor creado en el paso anterior
    return resultList;
  }

  //TODO: Recibe una lista de DTO de request de películas
  //EJERCICIO convertidores DTO --> Pelicula y hacer ciclo
  public List<Movie> saveMovie(List<Movie> movie) {
    return moviesRepository.saveAll(movie);
  }
  // FIN IMPLEMENTAR LUEGO

}
