package com.tmdb.tmdbapi.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.tmdb.tmdbapi.domain.MovieDetailed;
import com.tmdb.tmdbapi.domain.MoviePageResponse;

@FeignClient(name = "tmdb-api", url = "https://api.themoviedb.org/3")
public interface TmdbClient {

  @GetMapping("/movie/top_rated")
  MoviePageResponse getTopRatedMovies(
      @RequestHeader("Authorization") String bearerToken,
      @RequestParam(defaultValue = "1") Integer page,
      @RequestParam(defaultValue = "pt-BR") String language);

  @GetMapping("/search/movie?query={movieName}")
  MoviePageResponse getMovieByName(
      @RequestHeader("Authorization") String bearerToken,
      @PathVariable String movieName,
      @RequestParam(defaultValue = "1") Integer page,
      @RequestParam(defaultValue = "pt-BR") String language);

  @GetMapping("/discover/movie?with_genres={genreId}")
  MoviePageResponse getMovieByGenre(
      @RequestHeader("Authorization") String bearerToken,
      @PathVariable Integer genreId,
      @RequestParam(defaultValue = "1") Integer page,
      @RequestParam(defaultValue = "pt-BR") String language);

  @GetMapping("/movie/{movieId}")
  MovieDetailed getMovieDetails(
      @RequestHeader("Authorization") String bearerToken,
      @PathVariable Integer movieId,
      @RequestParam(defaultValue = "1") Integer page,
      @RequestParam(defaultValue = "pt-BR") String language);
}
