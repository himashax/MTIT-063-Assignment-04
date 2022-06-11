package com.MTIT.Microservices.MovieBookingService.controller;


import com.MTIT.Microservices.MovieBookingService.models.MovieBooking;
import com.MTIT.Microservices.MovieBookingService.service.MovieBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class MovieBookingController{

    @Autowired
    MovieBookingService bookingService;

    @GetMapping("/bookedmovies")
    public List<MovieBooking> getALlBookedMovies() {
        return bookingService.listBookedMovies();
    }

}
