package com.sourabh.onlineticketbooking.controller;

import com.sourabh.onlineticketbooking.dto.BookingDto;
import com.sourabh.onlineticketbooking.model.Booking;
import com.sourabh.onlineticketbooking.model.Enum.SeatCategory;
import com.sourabh.onlineticketbooking.model.Show;
import com.sourabh.onlineticketbooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping("/")
    public BookingDto doBooking(@RequestParam List<Integer> seatSelection, @RequestParam SeatCategory seatCategory, @RequestParam Long showID){
       return bookingService.reserve(showID,seatSelection,seatCategory);
    }


}
