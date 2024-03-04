package com.tmdb.tmdbapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmdb.tmdbapi.domain.MovieDetailed;
import com.tmdb.tmdbapi.domain.MoviePageResponse;
import com.tmdb.tmdbapi.exception.NotFoundException;
import com.tmdb.tmdbapi.feign.TmdbClient;
import com.tmdb.tmdbapi.util.GenreMapping;

@Service
public class TmdbService {
  @Autowired
  private TmdbClient tmdbClient;

  public MoviePageResponse getTopRatedMovies(String bearerToken, Integer page,
      String language) {
    return tmdbClient.getTopRatedMovies(bearerToken, page, language);
  }

  public MoviePageResponse getMovieByName(String bearerToken, String movieName,
      Integer page, String language) {
    return tmdbClient.getMovieByName(bearerToken, movieName, page, language);
  }

  public MoviePageResponse getMoviesByGenre(String bearerToken,
      String genreName, Integer page, String language) {
    Integer genreId = GenreMapping.getGenreId(genreName);

    if (genreId == null) {
      throw new NotFoundException("Genre not found.");
    }

    return tmdbClient.getMovieByGenre(bearerToken, genreId, page, language);
  }

  public MovieDetailed getMovieDetails(String bearerToken, Integer movieId,
      Integer page, String language) {

    return tmdbClient.getMovieDetails(bearerToken, movieId, page, language);
  }

}
