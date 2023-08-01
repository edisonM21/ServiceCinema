package com.cinema.globant.microservicesCinema.dto.movies;

import com.cinema.globant.microservicesCinema.entities.Genre;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * DTO for request in endpoint of new movie  creation
 *
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewMovieRequestDto {
  // original title
  private String originalTitle;
  // original language
  private String originalLanguage;
  // title in local language
  private String localTitle;
  // overview in local language
  private String overview;
  // flag if movie is for adults
  private Boolean isForAdults;
  // flag if movie is currently playing
  private Boolean nowPlaying;
  // List genres
  private List<GenreRequestDto> genres;
  // Id on API or null if its unknown
  private Integer apiId;
  // release date or null if movie is not known yet
  // En este caso para poder parsear adecuadamente una sola fecha
  // se debe establecer un Deserializador Json
  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
  private LocalDateTime releaseDate;
}
