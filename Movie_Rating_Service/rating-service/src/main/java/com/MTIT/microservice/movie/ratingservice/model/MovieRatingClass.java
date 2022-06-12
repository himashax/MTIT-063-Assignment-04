package com.MTIT.microservice.movie.ratingservice.model;

import lombok.*;

/**
 * Movie Rating Class
 * attributes
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieRatingClass {
  private String movieName;

  private int movieRating;

  private String description;
}
