package com.MTIT.microservice.movieservice;

import com.MTIT.microservice.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Movie Service Application
 */
@SpringBootApplication
public class MovieServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(MovieServiceApplication.class, args);
  }

  @Autowired private MovieRepository movieRepository;
}
