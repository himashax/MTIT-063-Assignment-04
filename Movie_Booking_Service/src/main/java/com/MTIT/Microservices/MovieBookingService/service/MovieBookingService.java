package com.MTIT.Microservices.MovieBookingService.service;

import com.MTIT.Microservices.MovieBookingService.models.MovieBooking;

import java.util.List;

public interface MovieBookingService {

    // Get all the booking details
    public List<MovieBooking> listBookedMovies();

    // Book a movie
    public void bookMovie(MovieBooking movieBooking);

    // Get a particular booking detail
    public MovieBooking getBookedMovieDetails(Integer movieBookingId);

    // Cancel booking
    public void deleteBooking(Integer movieBookingId);

    // Check availability of the movie hall

    public boolean bookingAvailability();

}
