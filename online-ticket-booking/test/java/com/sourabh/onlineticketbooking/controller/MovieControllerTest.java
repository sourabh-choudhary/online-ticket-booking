package com.sourabh.onlineticketbooking.controller;

import com.sourabh.onlineticketbooking.model.Enum.City;
import com.sourabh.onlineticketbooking.model.Movie;
import com.sourabh.onlineticketbooking.service.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = MovieController.class)
public class MovieControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private MovieService movieService;

    @Test
    public void getMoviesByCityTest() throws Exception {
        List<Movie> movieList=new ArrayList<>();
        when(movieService.getMovieByCity(City.Bangalore)).thenReturn(movieList);
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/movies/get/Bangalore"))
            .andExpect(status().isOk())
            .andReturn();
    }
}
