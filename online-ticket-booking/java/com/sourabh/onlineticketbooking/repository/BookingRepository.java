package com.sourabh.onlineticketbooking.repository;

import com.sourabh.onlineticketbooking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
