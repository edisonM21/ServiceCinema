package com.cinema.globant.microservicesCinema.dto.details;

import java.util.ArrayList;

public class Details {
    public int id;
    public Object poster_path;
    public String backdrop_path;
    public String original_title;
    public String title;
    public String overview;
    public double popularity;
    public String original_language;
    public boolean video;
    public String tagline;
    public ArrayList<ProductionCompany> production_companies;
    public ArrayList<Genre> genres;

}
