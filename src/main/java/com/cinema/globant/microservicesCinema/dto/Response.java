package com.cinema.globant.microservicesCinema.dto;

import lombok.Data;

import java.util.ArrayList;
@Data
public class Response {

    public int page;
    public ArrayList<Result> results;
    public int total_pages;
    public int total_results;

}

