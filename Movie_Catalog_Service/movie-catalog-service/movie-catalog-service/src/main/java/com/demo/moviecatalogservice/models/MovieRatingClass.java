package com.demo.moviecatalogservice.models;

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
