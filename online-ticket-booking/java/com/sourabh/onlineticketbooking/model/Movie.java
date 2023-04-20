package com.sourabh.onlineticketbooking.model;//package com.sourabh.booking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sourabh.onlineticketbooking.model.Enum.City;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "movie")
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="title",nullable = false)
    private String title;
    @Column(name="duration",nullable = false)
    private Integer movieDurationInMinutes;
    @OneToOne(mappedBy = "movie")
    @JsonIgnore
    private Show show;
    @Enumerated(EnumType.STRING)
    private City city;

}
