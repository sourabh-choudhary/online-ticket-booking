package com.sourabh.onlineticketbooking.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @OneToOne(mappedBy = "screen")
    private Show show;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "seat_id")
    private List<Seat> seats;
    @Column(name = "total_seats",nullable = false)
    private Integer totalSeats;
    @Column(name="booked_seats")
    private List<Integer> bookedSeats;
    @Column(name = "total_booked_seats",nullable = false)
    private Integer totalBookedSeats;
    @Version
    private Integer version;
}