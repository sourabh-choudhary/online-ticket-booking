package com.sourabh.onlineticketbooking.service.impl;

import com.sourabh.onlineticketbooking.dto.TheatreDto;
import com.sourabh.onlineticketbooking.exception.TheatreNotFoundException;
import com.sourabh.onlineticketbooking.model.Enum.City;
import com.sourabh.onlineticketbooking.model.Show;
import com.sourabh.onlineticketbooking.model.Theatre;
import com.sourabh.onlineticketbooking.repository.TheatreRepository;
import com.sourabh.onlineticketbooking.service.TheatreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreServiceImpl implements TheatreService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    TheatreRepository theatreRepository;

    @Override
    public Theatre addTheatre(Theatre theatre) {
        return theatreRepository.save(theatre);
    }

    @Override
    public List<Theatre> getTheatreList(City cityName,String movieName) {
        String logInfo = String.format("Requesting theatre List for city:%s",cityName);
        logger.debug(logInfo);
        List<Theatre> theatres= theatreRepository.findByCity(cityName);
        if(theatres.size()==0)
            throw new TheatreNotFoundException();
        logger.debug("%s theatres found",theatres.size());
        List<Theatre> result=new ArrayList<>();
        for(Theatre theatre:theatres){
            List<Show> shows=theatre.getShows();
            for(Show show:shows){
                if(show.getMovie().getTitle().equals(movieName))
                    result.add(theatre);
            }
        }
      return result;
    }
}
