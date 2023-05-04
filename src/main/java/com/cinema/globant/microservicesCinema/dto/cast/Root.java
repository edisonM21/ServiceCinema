package com.cinema.globant.microservicesCinema.dto.cast;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Root {
    public int id;
    public ArrayList<Cast> cast;
    public ArrayList<Crew> crew;
}
