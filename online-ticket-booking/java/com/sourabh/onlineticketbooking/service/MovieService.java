package com.sourabh.onlineticketbooking.service;

import com.sourabh.onlineticketbooking.model.Enum.City;
import com.sourabh.onlineticketbooking.model.Movie;

import java.util.List;

public interface MovieService {
    public Movie getMovieByName(String name);
    public Movie addMovie(Movie movie);
    public List<Movie> getMovieByCity(City cityName);
}
