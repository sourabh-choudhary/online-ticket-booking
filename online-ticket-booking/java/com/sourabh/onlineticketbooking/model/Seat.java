package com.sourabh.onlineticketbooking.model;

import com.sourabh.onlineticketbooking.model.Enum.SeatCategory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @Column(name = "seatNo", nullable = false)
    private Integer seatNo;
    @Enumerated(EnumType.STRING)
    private SeatCategory seatCategory;
    public Seat(Integer seatNo, SeatCategory seatCategory) {
        this.seatNo = seatNo;
        this.seatCategory = seatCategory;
    }
}
