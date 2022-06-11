package com.MTIT.Microservices.MovieBookingService.controller;


import com.MTIT.Microservices.MovieBookingService.models.Movie;
import com.MTIT.Microservices.MovieBookingService.models.MovieBooking;
import com.MTIT.Microservices.MovieBookingService.service.MovieBoookingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("/bookings")
public class MovieBookingController {

    @Autowired
    private MovieBoookingServiceImpl bookingService;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/get/{bookingId}")
    public String get(@PathVariable Integer bookingId){
        int movieId = bookingService.getBookedMovieDetails(bookingId).getMovieId();
        Movie movie = restTemplate.getForObject("http://localhost:8082/api/movie/"+movieId, Movie.class);
        return movie.toString();
    }

    @PostMapping("/book")
    public String add(@RequestBody MovieBooking movieBooking) {
        bookingService.bookMovie(movieBooking);
        return "Saved...";
    }

    @GetMapping("/view")
    public List<MovieBooking> getALlBookedMovies() {
        return bookingService.listBookedMovies();
    }

    @PutMapping("/book/{bookingId}")
    public String update(@RequestBody MovieBooking movieBooking, @PathVariable Integer bookingId) {
        MovieBooking getExistingBooking = bookingService.getBookedMovieDetails(bookingId);
        if(getExistingBooking.getBookingId() == movieBooking.getBookingId()){
            bookingService.bookMovie(movieBooking);
            return movieBooking.toString() + "Updated Successfully";
        }
        else{
            return "Selected Booking does not exist";
        }
    }

    @DeleteMapping("/view/{bookingId}")
    public String cancelBooking(@PathVariable Integer bookingId){
        bookingService.deleteBooking(bookingId);
        return "Booking " +  bookingId + " Cancelled Successfully";
    }

}
