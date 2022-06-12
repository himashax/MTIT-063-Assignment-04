package com.MTIT.microservice.movie.ratingservice.model;

import lombok.*;

/**
 * Movie model class
 * attributes
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
  private long movieId;

  private String movieTitle;

  private String movieType;

  private int year;
}
