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

    // View movie details of a booking
    @RequestMapping("/get/{bookingId}")
    public String get(@PathVariable Integer bookingId){
        // Get the id of the booked movie
        int movieId = bookingService.getBookedMovieDetails(bookingId).getMovieId();

        // API call to get the particular movie details by the movie id
        Movie movie = restTemplate.getForObject("http://localhost:8082/api/movie/"+movieId, Movie.class);
        return movie.toString();
    }

    // POST method for adding new booking details
    @PostMapping("/book")
    public String add(@RequestBody MovieBooking movieBooking) {
        bookingService.bookMovie(movieBooking);
        return "Saved...";
    }

    // GET method to view all the booking details
    @GetMapping("/view")
    public List<MovieBooking> getALlBookedMovies() {
        return bookingService.listBookedMovies();
    }

    // PUT method for updating the booking details
    @PutMapping("/book/{bookingId}")
    public String update(@RequestBody MovieBooking movieBooking, @PathVariable Integer bookingId) {
        // Get if there is an existing booking details for the requested booking id
        MovieBooking getExistingBooking = bookingService.getBookedMovieDetails(bookingId);

        // Check if the booking id of the updated details is corresponding to the requested booking id
        if(getExistingBooking.getBookingId() == movieBooking.getBookingId()){
            // Allow user to update if the ids are matching
            bookingService.bookMovie(movieBooking);

            // Returns the updated movie details
            return movieBooking.toString() + "Updated Successfully";
        }
        else{
            return "Selected Booking does not exist";
        }
    }

    // Delete method for deleting a booking record
    @DeleteMapping("/view/{bookingId}")
    public String cancelBooking(@PathVariable Integer bookingId){
        bookingService.deleteBooking(bookingId);
        return "Booking " +  bookingId + " Cancelled Successfully";
    }

}
