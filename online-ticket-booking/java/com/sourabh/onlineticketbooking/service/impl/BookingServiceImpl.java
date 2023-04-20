package com.sourabh.onlineticketbooking.service.impl;

import com.sourabh.onlineticketbooking.dto.BookingDto;
import com.sourabh.onlineticketbooking.exception.BookingException;
import com.sourabh.onlineticketbooking.exception.MovieNotFoundException;
import com.sourabh.onlineticketbooking.exception.SeatsNotAvailableException;
import com.sourabh.onlineticketbooking.model.Booking;
import com.sourabh.onlineticketbooking.model.Enum.SeatCategory;
import com.sourabh.onlineticketbooking.model.Screen;
import com.sourabh.onlineticketbooking.model.Seat;
import com.sourabh.onlineticketbooking.model.Show;
import com.sourabh.onlineticketbooking.repository.BookingRepository;
import com.sourabh.onlineticketbooking.repository.ScreenRepository;
import com.sourabh.onlineticketbooking.repository.ShowRepository;
import com.sourabh.onlineticketbooking.service.BookingService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    ShowRepository showRepository;
    @Autowired
    ScreenRepository screenRepository;

    @Override
    @Transactional
    public synchronized BookingDto reserve(Long showID, List<Integer> seatSelection, SeatCategory seatCategory) {

            Optional<Show> selectedShow =showRepository.findById(showID);
            if(selectedShow.isEmpty())
                throw new MovieNotFoundException();

            Optional<Screen> selectedScreen=screenRepository.findById(selectedShow.get().getScreen().getId());
            if(selectedScreen.isPresent()) {
                if (selectedScreen.get().getTotalSeats() < seatSelection.size())
                    throw new SeatsNotAvailableException();
                for (Integer seatNo : seatSelection) {
                    if (selectedScreen.get().getBookedSeats().contains(seatNo))
                        throw new BookingException();
                }
            }
            else
                throw new SeatsNotAvailableException();

          selectedScreen.get().setTotalBookedSeats(seatSelection.size());
          selectedScreen.get().setBookedSeats(seatSelection);
          screenRepository.save(selectedScreen.get());
          Booking booking=new Booking();
          booking.setShow(selectedShow.get());

          List<Seat> seats=selectedScreen.get().getSeats();
          List<Seat> list_bookedSeat=new ArrayList<>();
          int index=0;
          for(Integer seatNumber:seatSelection){
                seats.get(index).setSeatNo(seatNumber);
                seats.get(index).setSeatCategory(seatCategory);
                list_bookedSeat.add(seats.get(index));
                index++;
          }
          booking.setSeatsBooked(list_bookedSeat);
          bookingRepository.save(booking);
          logger.debug("booking is %s",booking);
          Long random= new Random().nextLong(10000L);
          List<Integer> list_seatNo=booking.getSeatsBooked().stream().map(x->x.getSeatNo()).collect(Collectors.toList());
          BookingDto bookingDto=new BookingDto(random, selectedScreen.get().getName()
                  ,selectedShow.get().getMovie().getTitle(),list_seatNo);
          return bookingDto;
    }
}
