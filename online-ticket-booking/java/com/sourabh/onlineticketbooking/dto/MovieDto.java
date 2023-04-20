package com.sourabh.onlineticketbooking.dto;

import com.sourabh.onlineticketbooking.model.Movie;
import com.sourabh.onlineticketbooking.model.Theatre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MovieDto {
    private String movie_name;
    private Integer movieDurationInMinutes;
    private Integer theatre_id;
}
