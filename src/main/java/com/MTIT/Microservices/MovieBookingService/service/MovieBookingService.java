package com.MTIT.Microservices.MovieBookingService.service;

import com.MTIT.Microservices.MovieBookingService.models.MovieBooking;
import com.MTIT.Microservices.MovieBookingService.repository.MovieBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MovieBookingService {

    @Autowired
    private MovieBookingRepository movieBookingRepository;

    public List<MovieBooking> listBookedMovies() {
        return movieBookingRepository.findAll();
    }

    public void bookMovie(MovieBooking movieBooking) {
        movieBookingRepository.save(movieBooking);
    }

    public MovieBooking getBookedMovieDetails(Integer movieBookingId) {
        return movieBookingRepository.findById(movieBookingId).get();
    }

    public void deleteBooking(Integer movieBookingId) {
        movieBookingRepository.deleteById(movieBookingId);
    }
}
