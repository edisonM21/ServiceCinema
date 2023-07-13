package com.cinema.globant.microservicesCinema.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Base response with code message and timestamp for POST endpoint
 * or error cases as well
 */

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponseDto {
  /*
   * En esta clase aprendemos a usar la anotación JSON Format
   * que instruye a con qué formato se deserializa un dato cuando el objeto
   * se convierte a JSON
   *
   * en el ejjemplo de la hora
   * Damos el formato de fecha hora
   * yyyy-MM-dd'T'HH:mm:ss  es el formato ISO con fecha y hora en UTC
   */

  // Code of action (to be defined)
  private String code;
  // Message with description
  private String message;
  // Timestamp of action with local server time
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
  private LocalDateTime timeStamp;

}
