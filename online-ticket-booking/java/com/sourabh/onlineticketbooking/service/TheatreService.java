package com.sourabh.onlineticketbooking.service;

import com.sourabh.onlineticketbooking.model.Enum.City;
import com.sourabh.onlineticketbooking.model.Movie;
import com.sourabh.onlineticketbooking.model.Theatre;

import java.util.List;

public interface TheatreService {

    public Theatre addTheatre(Theatre theatre);
    public List<Theatre> getTheatreList(City cityName,String movieName);
}
