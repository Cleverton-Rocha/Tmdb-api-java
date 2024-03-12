package com.tmdb.tmdbapi.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import feign.FeignException;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<String> handleNotFoundException(NotFoundException ex) {
    return ResponseEntity.status(404).body(ex.getMessage());
  }

  @ExceptionHandler(FeignException.NotFound.class)
  public ResponseEntity<String> handleFeignNotFound(
      FeignException.NotFound ex) {
    return ResponseEntity.status(404).body("Movie not found.");
  }

  @ExceptionHandler(FeignException.Unauthorized.class)
  public ResponseEntity<String> handleFeignUnauthorized(
      FeignException.Unauthorized ex) {
    return ResponseEntity.status(401).body("Unauthorized");
  }
}
