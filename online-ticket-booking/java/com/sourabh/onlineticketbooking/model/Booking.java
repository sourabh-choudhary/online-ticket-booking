package com.sourabh.onlineticketbooking.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name="show_id",referencedColumnName="id")
    private Show show;
    @OneToMany
    @JoinColumn(name = "seat_id", referencedColumnName = "id")
    private List<Seat> seatsBooked;
    @Version
    private Integer version;

}
