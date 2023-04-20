package com.sourabh.onlineticketbooking;

import com.sourabh.onlineticketbooking.model.*;
import com.sourabh.onlineticketbooking.model.Enum.City;
import com.sourabh.onlineticketbooking.model.Enum.SeatCategory;
import com.sourabh.onlineticketbooking.repository.ScreenRepository;
import com.sourabh.onlineticketbooking.repository.ShowRepository;
import com.sourabh.onlineticketbooking.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class OnlineTicketBookingApplication implements CommandLineRunner {

	@Autowired
	TheatreRepository theatreRepository;
	@Autowired
	ShowRepository showRepository;
	@Autowired
	ScreenRepository screenRepository;

	public static void main(String[] args) {
		SpringApplication.run(OnlineTicketBookingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Show show=new Show();
		Show show1=new Show();
		Movie movie=new Movie();
		movie.setTitle("Bahubali");
		movie.setMovieDurationInMinutes(120);
		movie.setCity(City.Bangalore);
		Movie movie1=new Movie();
		movie1.setTitle("KGF");
		movie1.setMovieDurationInMinutes(120);
		movie1.setCity(City.Bangalore);

		Screen screen=new Screen();
		screen.setName("Screen1");

		Screen screen1=new Screen();
		screen1.setName("Screen2");
        //Seats
		Seat seat1=new Seat(1,SeatCategory.PLATINUM);
		Seat seat2=new Seat(2,SeatCategory.SILVER);
		Seat seat3=new Seat(3,SeatCategory.GOLD);
		List<Seat> seats=new ArrayList<>();
		seats.add(seat1);
		seats.add(seat2);
		seats.add(seat3);

		Seat seat4=new Seat(1,SeatCategory.PLATINUM);
		Seat seat5=new Seat(2,SeatCategory.SILVER);
		Seat seat6=new Seat(3,SeatCategory.GOLD);
		List<Seat> seats_list=new ArrayList<>();
		seats_list.add(seat4);
		seats_list.add(seat5);
		seats_list.add(seat6);
		//Screen
        screen.setSeats(seats);
		screen.setTotalSeats(3);
		screen.setTotalBookedSeats(0);
		List<Integer> bookedSeats=new ArrayList<>();
		screen.setBookedSeats(bookedSeats);

		screen1.setSeats(seats_list);
		screen1.setTotalSeats(3);
		screen1.setTotalBookedSeats(0);
		List<Integer> bookedSeats1=new ArrayList<>();
		screen1.setBookedSeats(bookedSeats1);

		Theatre theatre=new Theatre();
		theatre.setCity(City.Bangalore);
		theatre.setName("theatre1");
		show.setScreen(screen);
		show.setMovie(movie);

		Theatre theatre1=new Theatre();
		theatre1.setCity(City.Bangalore);
		theatre1.setName("theatre2");
		show1.setScreen(screen1);
		show1.setMovie(movie1);

		theatre.setShows(Collections.singletonList(show));
		theatre1.setShows(Collections.singletonList(show1));
		theatreRepository.save(theatre);
		theatreRepository.save(theatre1);

	}
}
