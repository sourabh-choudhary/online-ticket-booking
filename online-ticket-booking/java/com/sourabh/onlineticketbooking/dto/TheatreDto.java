package com.sourabh.onlineticketbooking.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sourabh.onlineticketbooking.model.Enum.City;
import com.sourabh.onlineticketbooking.model.Show;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TheatreDto {
        private  String name;
        private List<Show> shows;
        private City city;
}
