package com.sourabh.onlineticketbooking.model;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sourabh.onlineticketbooking.model.Enum.City;
import com.sourabh.onlineticketbooking.model.Enum.SeatCategory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @Column(name = "name", nullable = false)
    private  String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Show> shows;
    @Enumerated(EnumType.STRING)
    private City city;
}
