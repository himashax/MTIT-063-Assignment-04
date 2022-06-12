package com.MTIT.microservice.movieservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * Custom Exception Class
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

  /**
   * ResourceNotFoundException method
   * @param message
   */
  public ResourceNotFoundException(String message) {
    super(message);
  }
}
