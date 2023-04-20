package com.sourabh.onlineticketbooking.controller;

import com.sourabh.onlineticketbooking.model.Enum.City;
import com.sourabh.onlineticketbooking.model.Movie;
import com.sourabh.onlineticketbooking.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add")
    public Movie addMovie(@RequestBody Movie movie){
        return movieService.addMovie(movie);
    }

    @GetMapping("/get/{cityName}")
    public List<Movie> getMovieByCity(@PathVariable City cityName){
        return movieService.getMovieByCity(cityName);
    }


}
