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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@RestController
@RequestMapping("/api/movies")
@SecurityRequirement(name = "bearerAuth")
@SecurityScheme(name = "bearerAuth", type = SecuritySchemeType.HTTP, scheme = "bearer", bearerFormat = "JWT")
public class TmdbController {
    @Autowired
    private TmdbService tmdbService;

    @Operation(description = "Retorna uma lista de filmes bem avaliados.")
    @ApiResponse(responseCode = "200", description = "Retorna uma lista de filmes.")
    @GetMapping("/top_rated")
    public ResponseEntity<MoviePageResponse> getTopRatedMovies(
            @RequestHeader("Authorization") String bearerToken,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "pt-BR") String language) {
        return ResponseEntity
                .ok(tmdbService.getTopRatedMovies(bearerToken, page, language));
    }

    @Operation(description = "Retorna uma lista de filmes procurado pela palavra chave.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna uma lista de filmes filmes procurado pela palavra chave."),
            @ApiResponse(responseCode = "404", description = "Retorna 'Movie not found' caso não ache nenhum filme com a palavra chave indicada.", content = @Content(mediaType = "text/plain", examples = @ExampleObject(value = "Movie not found."))) })
    @GetMapping("/movie/{movieName}")
    public ResponseEntity<MoviePageResponse> getMovieByName(
            @RequestHeader("Authorization") String bearerToken,
            @PathVariable String movieName,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "pt-BR") String language) {
        return ResponseEntity.ok(tmdbService.getMovieByName(bearerToken,
                movieName, page, language));
    }

    @Operation(description = "Retorna uma lista de filmes procurado pela palavra chave do id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna uma lista de filmes procurado pela palavra chave do id."),
            @ApiResponse(responseCode = "404", description = "Retorna 'Genre not found' caso não ache nenhum gênero com a palavra chave indicada.", content = @Content(mediaType = "text/plain", examples = @ExampleObject(value = "Genre not found."))) })
    @GetMapping("/genre/{genreName}")
    public ResponseEntity<MoviePageResponse> getMovieByGenre(
            @RequestHeader("Authorization") String bearerToken,
            @PathVariable String genreName,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "pt-BR") String language) {
        return ResponseEntity.ok(tmdbService.getMoviesByGenre(bearerToken,
                genreName, page, language));
    }

    @Operation(description = "Retorna um filme procurado pelo id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna um filme procurado pelo id."),
            @ApiResponse(responseCode = "404", description = "Retorna 'Movie not found' caso não ache nenhum filme com a palavra chave indicada.", content = @Content(mediaType = "text/plain", examples = @ExampleObject(value = "Movie not found."))) })
    @GetMapping("/movie/{movieId}/details")
    public ResponseEntity<MovieDetailed> getMovieDetails(
            @RequestHeader("Authorization") String bearerToken,
            @PathVariable Integer movieId,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "pt-BR") String language) {
        return ResponseEntity.ok(tmdbService.getMovieDetails(bearerToken,
                movieId, page, language));
    }
}
