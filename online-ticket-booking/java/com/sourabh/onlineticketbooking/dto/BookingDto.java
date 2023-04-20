package com.sourabh.onlineticketbooking.dto;

import com.sourabh.onlineticketbooking.model.Show;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class BookingDto {
    private Long booking_id;
    private String screen_name;
    private String movie_name;
    private List<Integer> booked_seats;

}
