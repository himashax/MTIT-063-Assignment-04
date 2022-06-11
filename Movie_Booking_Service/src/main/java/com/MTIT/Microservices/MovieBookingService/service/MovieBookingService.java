package com.MTIT.Microservices.MovieBookingService.service;

import com.MTIT.Microservices.MovieBookingService.models.MovieBooking;

import java.util.List;

public interface MovieBookingService {

    public List<MovieBooking> listBookedMovies();
    public void bookMovie(MovieBooking movieBooking);
    public MovieBooking getBookedMovieDetails(Integer movieBookingId);
    public void deleteBooking(Integer movieBookingId);

}
