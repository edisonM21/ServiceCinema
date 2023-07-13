package com.cinema.globant.microservicesCinema.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "movie_genre")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Genre {

  @Id
  @Column(name="genre_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
  private int id;

  // metadata en @Colum
  // unique porque hay un solo género con un nombre
  @Column(name= "grenre_name", nullable = false,  unique = true, length = 20)
  private String name;

  @Column(name= "grenre_description", nullable = false, length = 200)
  private String description;

  @Column(name= "grenre_rate", nullable = false)
  private int rate = 0;


}
