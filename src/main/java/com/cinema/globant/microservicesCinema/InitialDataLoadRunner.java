package com.cinema.globant.microservicesCinema;

import com.cinema.globant.microservicesCinema.entities.Genre;
import com.cinema.globant.microservicesCinema.entities.Movie;
import com.cinema.globant.microservicesCinema.repositories.GenreRepository;
import com.cinema.globant.microservicesCinema.repositories.MoviesRepository;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.Month;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

/**
 * Clase Runner con implementación de llenado inicial de la BD
 */
// La implementación de command line runner permite hacer una función
// que se ejecuta al levantar la app
@Service
public class InitialDataLoadRunner implements CommandLineRunner {
  private GenreRepository genreRepository;
  private MoviesRepository moviesRepository;

  // Es preferible inyectar las dependencias via constructor y no con @Autowired
  // Se puede hacer con la anotación de lombok
  public InitialDataLoadRunner(GenreRepository genreRepository, MoviesRepository moviesRepository) {
    this.genreRepository = genreRepository;
    this.moviesRepository = moviesRepository;
  }

  // la anotación @Transactional es para que permita insertar en BD.
  @Override
  @Transactional
  public void run(String... args) throws Exception {

    // precargado de la tabla de generos
    System.out.println("INICIAMOS CARGA BD");
    createInitialGenres();
    createInitialMovies();
    System.out.println("FINALIZA CARGA BD");

  }

  private void createInitialGenres() {
    genreRepository.save(Genre
        .builder()
        .name("Action")
        .description("Action films, military films")
        .build());

    genreRepository.save(Genre
        .builder()
        .name("Horror")
        .description("Ghost and horror films")
        .build());
  }

  private void createInitialMovies() {

    // creación de películas estrenadas
    // transformers
    moviesRepository.save(Movie
        .builder()
        .adult(false)
        .apiId(0)
        .originalLanguage("EN")
        .originalTitle("Transformers: Rise of the Beasts")
        .title("Transformers: El despertar de las bestias")
        .overview("Regresando a la acción y espectáculo que han capturado a los amantes del cine alrededor del mundo, Transformers: El Despertar de las Bestias transportará a las audiencias a una aventura mundial de los 90s con los Autobots, y traerá a una nueva facción de Transformers - los Maximals - a la batalla existente en la tierra entre los Autobots y los Decepticons. ")
        .nowPlaying(true)
        .releaseDate(LocalDateTime.of(2023, Month.JUNE, 8, 0, 0, 0))
        .backdropPath("")
        .posterPath("")
        .video(false)
        .voteAverage(0.0D)
        .voteCount(0)
        .popularity(0.0)
        .build());
    // emperatriz rebelde
    moviesRepository.save(Movie
        .builder()
        .adult(true)
        .apiId(0)
        .originalLanguage("FR")
        .originalTitle("Corsage")
        .title("La emperatriz rebelde")
        .overview("La emperatriz Isabel de Austria es idolatrada por su belleza y reconocida por inspirar las tendencias de la moda. En 1877, la Emperatriz cumple 40 años y se considera oficialmente una anciana que comienza a tratar de mantener su imagen.")
        .nowPlaying(true)
        .releaseDate(LocalDateTime.of(2023, Month.JUNE, 8, 0, 0, 0))
        .backdropPath("")
        .posterPath("")
        .video(false)
        .voteAverage(0.0D)
        .voteCount(0)
        .popularity(0.0)
        .build());

    // flash
    moviesRepository.save(Movie
        .builder()
        .adult(false)
        .apiId(0)
        .originalLanguage("EN")
        .originalTitle("The Flash")
        .title("Flash")
        .overview("Los mundos chocan en \"Flash\" cuando Barry utiliza sus superpoderes para viajar en el tiempo y cambiar los acontecimientos del pasado. Barry intenta salvar a su familia, pero sin saberlo altera el futuro y queda atrapado en una realidad en la que el general Zod ha regresado y amenaza con la aniquilación, pero en la que no hay Superhéroes a los que recurrir. A menos que Barry pueda persuadir a un Batman muy diferente para que salga de su retiro y rescate a un kryptoniano encarcelado... aunque no sea el que está buscando. En última instancia, para salvar el mundo en el que se encuentra y regresar al futuro que conoce, la única esperanza de Barry es luchar por seguir vivo. Pero ¿este último sacrificio será suficiente para reiniciar el universo?")
        .nowPlaying(false)
        .releaseDate(LocalDateTime.of(2023, Month.JUNE, 15, 0, 0, 0))
        .backdropPath("")
        .posterPath("")
        .video(false)
        .voteAverage(0.0D)
        .voteCount(0)
        .popularity(0.0)
        .build());


    // elementos
    moviesRepository.save(Movie
        .builder()
        .adult(false)
        .apiId(0)
        .originalLanguage("EN")
        .originalTitle("Elemental")
        .title("Elementos")
        .overview("ELEMENTOS es la nueva pelicula de Disney y Pixar, ambientado en Elemental City, donde conviven los habitantes del fuego, el agua, la tierra y el aire. La historia nos presenta a Ember, una joven dura, ingeniosa y feroz, cuya amistad con un chico divertido y que se deja llevar por la corriente, llamado Wade, desafía sus creencias sobre el mundo en el que viven.")
        .nowPlaying(false)
        .releaseDate(LocalDateTime.of(2023, Month.JUNE, 22, 0, 0, 0))
        .backdropPath("")
        .posterPath("")
        .video(false)
        .voteAverage(0.0D)
        .voteCount(0)
        .popularity(0.0)
        .build());

    // el colibri
    moviesRepository.save(Movie
        .builder()
        .adult(true)
        .apiId(0)
        .originalLanguage("FR")
        .originalTitle("The Hummingbird")
        .title("El Colibrí")
        .overview("Basada en el best seller internacional del autor Sandro Veronesi, esta historia sigue la vida de Marco Carrera (Pierfrancesco Favino de Nostalgia), desde su niñez hasta su adultez, atravesando amores, fracasos y pérdidas. La historia salta de una época a otra según los recuerdos, en un tiempo líquido que va desde principios de los años setenta hasta un futuro próximo.")
        .nowPlaying(false)
        .releaseDate(LocalDateTime.of(2023, Month.JUNE, 22, 0, 0, 0))
        .backdropPath("")
        .posterPath("")
        .video(false)
        .voteAverage(0.0D)
        .voteCount(0)
        .popularity(0.0)
        .build());

    // indiana
    moviesRepository.save(Movie
        .builder()
        .adult(false)
        .apiId(0)
        .originalLanguage("EN")
        .originalTitle("Indiana Jones and the Dial of Destiny")
        .title("Indiana Jones y el dial del destino")
        .overview("Al encontrarse en una nueva era, a punto de jubilarse, Indy lucha por encajar en un mundo que parece habérsele quedado pequeño. Pero cuando los tentáculos de un mal demasiado familiar regresan en la forma de un viejo rival, Indy debe ponerse su sombrero y coger su látigo una vez más para asegurarse de que un antiguo y poderoso artefacto no caiga en las manos equivocadas.")
        .nowPlaying(false)
        .releaseDate(LocalDateTime.of(2023, Month.JUNE, 29, 0, 0, 0))
        .backdropPath("")
        .posterPath("")
        .video(false)
        .voteAverage(0.0D)
        .voteCount(0)
        .popularity(0.0)
        .build());

    // creación de películas no estrenadas
    // Barbie
    moviesRepository.save(Movie
        .builder()
        .adult(false)
        .apiId(0)
        .originalLanguage("EN")
        .originalTitle("Barbie")
        .title("Barbie La Película")
        .overview("Vivir en Barbie Land es ser un ser perfecto en un lugar perfecto, a menos que tengas una crisis existencial total, o seas un Ken.")
        .nowPlaying(false)
        .releaseDate(LocalDateTime.of(2023, Month.JULY, 20, 0, 0, 0))
        .backdropPath("")
        .posterPath("")
        .video(false)
        .voteAverage(0.0D)
        .voteCount(0)
        .popularity(0.0)
        .build());

    //Openheimer
    moviesRepository.save(Movie
        .builder()
        .adult(true)
        .apiId(0)
        .originalLanguage("EN")
        .originalTitle("Oppenheimer")
        .title("Oppenheimer")
        .overview("Escrita y dirigida por Christopher Nolan, Oppenheimer es un thriller épico que sumerge al público en la trepidante paradoja del enigmático hombre que debe arriesgarse a destruir el mundo para poder salvarlo. ")
        .nowPlaying(false)
        .releaseDate(LocalDateTime.of(2023, Month.JULY, 20, 0, 0, 0))
        .backdropPath("")
        .posterPath("")
        .video(false)
        .voteAverage(0.0D)
        .voteCount(0)
        .popularity(0.0)
        .build());

    //El libro de los deseos
    moviesRepository.save(Movie
        .builder()
        .adult(true)
        .apiId(0)
        .originalLanguage("FR")
        .originalTitle("La Chambre Des Marveilles ")
        .title("El libro de los deseos")
        .overview("Después de que un trágico accidente deja en coma a su hijo, Thelma decide completar una a una las 10 cosas que hay que hacer antes del fin del mundo\" que dejó el niño escrito en su diario. Esto con la esperanza de demostrarle todo lo maravilloso que ofrece la vida para que él decida regresar, y de paso reavivar sus propias ganas de vivir.")
        .nowPlaying(false)
        .releaseDate(LocalDateTime.of(2023, Month.AUGUST, 4, 0, 0, 0))
        .backdropPath("")
        .posterPath("")
        .video(false)
        .voteAverage(0.0D)
        .voteCount(0)
        .popularity(0.0)
        .build());

    // Dune 2
    moviesRepository.save(Movie
        .builder()
        .adult(false)
        .apiId(0)
        .originalLanguage("FR")
        .originalTitle("Dune Part Two")
        .title("Dune Parte 2")
        .overview("Duna: Parte dos explorará el viaje mítico de Paul Atreides mientras se une a Chani y los Fremen en su camino de venganza contra los conspiradores que destruyeron a su familia. Enfrentando la decisión entre el amor de su vida y el destino del universo, Paul se esfuerza por evitar un futuro terrible que sólo él puede prever. ")
        .nowPlaying(false)
        .releaseDate(LocalDateTime.of(2023, Month.NOVEMBER, 2, 0, 0, 0))
        .backdropPath("")
        .posterPath("")
        .video(false)
        .voteAverage(0.0D)
        .voteCount(0)
        .popularity(0.0)
        .build());
  }
}
