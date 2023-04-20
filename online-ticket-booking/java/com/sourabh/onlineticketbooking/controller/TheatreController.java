package com.sourabh.onlineticketbooking.controller;


import com.sourabh.onlineticketbooking.model.Enum.City;
import com.sourabh.onlineticketbooking.model.Movie;
import com.sourabh.onlineticketbooking.model.Theatre;
import com.sourabh.onlineticketbooking.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/theatre")
public class TheatreController {

    @Autowired
    TheatreService theatreService;
    @GetMapping("/get/{cityName}/{movieName}")
    public List<Theatre> getTheatreByCity(@PathVariable City cityName, @PathVariable String movieName){
        return theatreService.getTheatreList(cityName,movieName);
    }

    @PostMapping("/add")
    public Theatre addMovie(@RequestBody Theatre theatre){
        return theatreService.addTheatre(theatre);
    }
}
