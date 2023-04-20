package com.sourabh.onlineticketbooking.service.impl;

import com.sourabh.onlineticketbooking.dto.MovieDto;
import com.sourabh.onlineticketbooking.exception.MovieNotFoundException;
import com.sourabh.onlineticketbooking.model.Enum.City;
import com.sourabh.onlineticketbooking.model.Movie;
import com.sourabh.onlineticketbooking.repository.MovieRepository;
import com.sourabh.onlineticketbooking.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    MovieRepository movieRepository;

    @Override
    public Movie getMovieByName(String name){
        if(name!=null)
            return movieRepository.findByTitle(name);

        return null;
    }
    @Override
    public List<Movie> getMovieByCity(City cityName){
        List<Movie> movies= movieRepository.findByCity(cityName);
        logger.debug("%s movies found",movies.size());
        if(movies.size()==0)
            throw new MovieNotFoundException() ;
       return movies;
    }
    @Override
    public Movie addMovie(Movie movie){
        return movieRepository.save(movie);
    }

}
