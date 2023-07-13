package com.cinema.globant.microservicesCinema.dto.movies;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * DTO for request in endpoint of new movie  update
 *
 * For creation only basic fields will be required.
 *
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMovieRequestDto {
  // movie Id
  private Long id;
  // original title
  private String originalTitle;
  // original languaje
  private String originalLanguage;
  // title in local language
  private String localTitle;
  // overview in local language
  private String overview;
  // flag if movie is for adults
  private Boolean isForAdults;
  // flag if movie is currently playing
  private Boolean nowPlaying;
  // release date or null if movie is not known yet
  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
  private LocalDateTime releaseDate;
  // Id on API or null if its unknown
  private Integer apiId;
  // does the movie has video ?
  private Boolean  hasVideo;
  // popularity or 0 if is unknown
  private Double popularity;
  // vote average or 0 if is unknown
  private Double voteAverage;
  // vote count or 0 if is unknown
  private Integer voteCount = 0;
}
