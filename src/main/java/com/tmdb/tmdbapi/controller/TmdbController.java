package com.tmdb.tmdbapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tmdb.tmdbapi.domain.MovieDetailed;
import com.tmdb.tmdbapi.domain.MoviePageResponse;
import com.tmdb.tmdbapi.service.TmdbService;

@RestController
@RequestMapping("/api/movies")
public class TmdbController {
  @Autowired
  private TmdbService tmdbService;

  @GetMapping("/top_rated")
  public ResponseEntity<MoviePageResponse> getTopRatedMovies(
      @RequestHeader("Authorization") String bearerToken,
      @RequestParam(defaultValue = "1") Integer page,
      @RequestParam(defaultValue = "pt-BR") String language) {
    return ResponseEntity
        .ok(tmdbService.getTopRatedMovies(bearerToken, page, language));
  }

  @GetMapping("/movie/{movieName}")
  public ResponseEntity<MoviePageResponse> getMovieByName(
      @RequestHeader("Authorization") String bearerToken,
      @PathVariable String movieName,
      @RequestParam(defaultValue = "1") Integer page,
      @RequestParam(defaultValue = "pt-BR") String language) {
    return ResponseEntity
        .ok(tmdbService.getMovieByName(bearerToken, movieName, page, language));
  }

  @GetMapping("/genre/{genreName}")
  public ResponseEntity<MoviePageResponse> getMovieByGenre(
      @RequestHeader("Authorization") String bearerToken,
      @PathVariable String genreName,
      @RequestParam(defaultValue = "1") Integer page,
      @RequestParam(defaultValue = "pt-BR") String language) {
    return ResponseEntity.ok(
        tmdbService.getMoviesByGenre(bearerToken, genreName, page, language));
  }

  @GetMapping("/movie/{movieId}/details")
  public ResponseEntity<MovieDetailed> getMovieDetails(
      @RequestHeader("Authorization") String bearerToken,
      @PathVariable Integer movieId,
      @RequestParam(defaultValue = "1") Integer page,
      @RequestParam(defaultValue = "pt-BR") String language) {
    return ResponseEntity
        .ok(tmdbService.getMovieDetails(bearerToken, movieId, page, language));
  }
}
