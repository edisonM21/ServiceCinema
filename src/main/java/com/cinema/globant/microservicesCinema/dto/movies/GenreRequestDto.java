package com.cinema.globant.microservicesCinema.dto.movies;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreRequestDto {
    //Id genre
    private Long id;
    //name genre
    private String name;
}
