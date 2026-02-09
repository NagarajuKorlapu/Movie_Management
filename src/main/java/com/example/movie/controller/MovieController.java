package com.example.movie.controller;

import com.example.movie.model.Movie;
import com.example.movie.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * REST Controller for managing movies.
 */
@RestController
@RequestMapping("/api/movies")
// Allow cross-origin requests from any source for simplicity in this demo
@CrossOrigin(origins = "*") 
public class MovieController {

    private final MovieService movieService;

    // Constructor injection
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    /**
     * POST /api/movies
     * Adds a new movie.
     * Validates that the name is not null or blank.
     */
    @PostMapping
    public ResponseEntity<?> addMovie(@RequestBody Movie movie) {
        if (movie.getName() == null || movie.getName().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Movie name is required.");
        }
        Movie savedMovie = movieService.addMovie(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMovie);
    }

    /**
     * GET /api/movies/{id}
     * Fetches a movie by ID.
     * Returns 404 if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        Optional<Movie> movie = movieService.getMovieById(id);
        
        // Ensure functional style usage for cleaner code
        return movie.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
