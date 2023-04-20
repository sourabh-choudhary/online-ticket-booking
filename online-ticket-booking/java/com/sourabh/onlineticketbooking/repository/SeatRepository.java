package com.sourabh.onlineticketbooking.repository;//package com.sourabh.booking.repository;

import com.sourabh.onlineticketbooking.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat,Integer> {
}
