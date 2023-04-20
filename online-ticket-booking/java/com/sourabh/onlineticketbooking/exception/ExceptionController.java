package com.sourabh.onlineticketbooking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = TheatreNotFoundException.class)
    public ResponseEntity<Object> exception(TheatreNotFoundException exception) {
        return new ResponseEntity<>("No theatre found in selected City", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = MovieNotFoundException.class)
    public ResponseEntity<Object> exception(MovieNotFoundException exception) {
        return new ResponseEntity<>("No movie found in selected City", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = BookingException.class)
    public ResponseEntity<Object> exception(BookingException exception) {
        return new ResponseEntity<>("Please select seats again", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = SeatsNotAvailableException.class)
    public ResponseEntity<Object> exception(SeatsNotAvailableException exception) {
        return new ResponseEntity<>("Seats not available, please select another show", HttpStatus.BAD_REQUEST);
    }
}
