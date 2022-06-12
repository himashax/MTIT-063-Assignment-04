package com.MTIT.microservice.movie.ratingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * rating service application
 */
@SpringBootApplication
public class RatingServiceApplication {

  /**
   * main class
   * @param args
   */
  public static void main(String[] args) {
    SpringApplication.run(RatingServiceApplication.class, args);
  }

  /**
   * designed to call REST services
   * specify that
   * @return Bean to be managed by Spring context
   */
  @Bean
  public RestTemplate getRestTemplate() {
    return new RestTemplate();
  }
}
