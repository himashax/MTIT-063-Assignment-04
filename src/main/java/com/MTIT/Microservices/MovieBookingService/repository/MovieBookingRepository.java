package com.MTIT.Microservices.MovieBookingService.repository;

import com.MTIT.Microservices.MovieBookingService.models.MovieBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

public interface MovieBookingRepository extends JpaRepository<MovieBooking, Integer> {

}
