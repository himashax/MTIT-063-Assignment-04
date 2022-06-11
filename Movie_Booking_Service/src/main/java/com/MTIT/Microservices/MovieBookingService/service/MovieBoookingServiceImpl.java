package com.MTIT.Microservices.MovieBookingService.service;

import com.MTIT.Microservices.MovieBookingService.models.MovieBooking;
import com.MTIT.Microservices.MovieBookingService.repository.MovieBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieBoookingServiceImpl implements MovieBookingService {
    @Autowired
    private MovieBookingRepository movieBookingRepository;

    @Override
    public List<MovieBooking> listBookedMovies() {
        return movieBookingRepository.findAll();
    }

    @Override
    public void bookMovie(MovieBooking movieBooking) {
        movieBookingRepository.save(movieBooking);
    }

    @Override
    public MovieBooking getBookedMovieDetails(Integer movieBookingId) {
        return movieBookingRepository.findById(movieBookingId).get();
    }
    @Override
    public void deleteBooking(Integer movieBookingId) {
        movieBookingRepository.deleteById(movieBookingId);
    }
}
