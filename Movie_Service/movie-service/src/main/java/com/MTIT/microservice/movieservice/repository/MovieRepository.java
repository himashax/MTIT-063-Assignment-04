package com.MTIT.microservice.movieservice.repository;

import com.MTIT.microservice.movieservice.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    //all create, read, update, delete methods
}
