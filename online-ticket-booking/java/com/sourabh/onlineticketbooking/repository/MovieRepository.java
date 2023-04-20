package com.sourabh.onlineticketbooking.repository;

import com.sourabh.onlineticketbooking.model.Enum.City;
import com.sourabh.onlineticketbooking.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Long> {
     Movie findByTitle(final String title);
     List<Movie> findByCity(final City city);

}
