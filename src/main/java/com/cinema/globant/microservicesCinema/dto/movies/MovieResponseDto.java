package com.cinema.globant.microservicesCinema.dto.movies;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * DTO for response of movie records. For be updated in the future with mor information
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponseDto {
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
  private boolean isForAdults;
  // flag if movie is currently playing
  private boolean nowPlaying;
  // release date or null if movie is not known yet
  @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
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
