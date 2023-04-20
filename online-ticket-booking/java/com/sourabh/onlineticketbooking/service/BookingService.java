package com.sourabh.onlineticketbooking.service;

import com.sourabh.onlineticketbooking.dto.BookingDto;
import com.sourabh.onlineticketbooking.model.Booking;
import com.sourabh.onlineticketbooking.model.Enum.SeatCategory;
import com.sourabh.onlineticketbooking.model.Show;

import java.util.List;

public interface BookingService {

    public BookingDto reserve(Long showID, List<Integer> seatSelection, SeatCategory seatCategory);

}
