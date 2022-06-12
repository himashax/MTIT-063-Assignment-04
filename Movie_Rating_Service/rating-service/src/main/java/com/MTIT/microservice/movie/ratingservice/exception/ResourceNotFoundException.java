package com.MTIT.microservice.movie.ratingservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * custom exception class
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

  /**
   * ResourceNotFoundException
   * @param message
   */
  public ResourceNotFoundException(String message) {
    super(message);
  }
}
