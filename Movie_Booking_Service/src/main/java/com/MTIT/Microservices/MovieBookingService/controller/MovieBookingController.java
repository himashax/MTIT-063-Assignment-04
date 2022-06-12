package com.MTIT.Microservices.MovieBookingService.controller;


import com.MTIT.Microservices.MovieBookingService.models.Movie;
import com.MTIT.Microservices.MovieBookingService.models.MovieBooking;
import com.MTIT.Microservices.MovieBookingService.service.MovieBookingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("/bookings")
public class MovieBookingController {

    @Autowired
    private MovieBookingServiceImpl bookingService;

    // POST method for adding new booking details
    @PostMapping("/book")
    public String add(@RequestBody MovieBooking movieBooking) {
        bookingService.bookMovie(movieBooking);
        return movieBooking.toString();
    }

    // GET method to view all the booking details
    @GetMapping("/view")
    public List<MovieBooking> getALlBookedMovies() {
        return bookingService.listBookedMovies();
    }

    // PUT method for updating the booking details
    @PutMapping("/book/{bookingId}")
    public String update(@RequestBody MovieBooking movieBooking, @PathVariable int bookingId) {
        // Update and returns the updated movie details
        return bookingService.updateBooking(movieBooking, bookingId);

    }

    // Delete method for deleting a booking record
    @DeleteMapping("/view/{bookingId}")
    public String cancelBooking(@PathVariable int bookingId){
        bookingService.deleteBooking(bookingId);
        return "Booking " +  bookingId + " Cancelled Successfully";
    }

    // View movie details of a booking
    @RequestMapping("/get/{bookingId}")
    public String get(@PathVariable int bookingId){
        return bookingService.getMovieDetails(bookingId).toString();
    }

}
