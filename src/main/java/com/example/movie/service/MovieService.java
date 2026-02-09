package com.example.movie.service;

import com.example.movie.model.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Service class to handle movie operations.
 * Uses an in-memory ArrayList for storage.
 */
@Service
public class MovieService {

    // In-memory storage for movies
    private final List<Movie> movies = new ArrayList<>();
    
    // Auto-increment ID generator
    private final AtomicLong idCounter = new AtomicLong(1);

    /**
     * Adds a new movie to the list.
     * Assigns a unique ID to the movie.
     *
     * @param movie The movie to add.
     * @return The added movie with its generated ID.
     */
    public Movie addMovie(Movie movie) {
        movie.setId(idCounter.getAndIncrement());
        movies.add(movie);
        return movie;
    }

    /**
     * Retrieves a movie by its ID.
     *
     * @param id The ID of the movie to retrieve.
     * @return An Optional containing the movie if found, or empty otherwise.
     */
    public Optional<Movie> getMovieById(Long id) {
        return movies.stream()
                .filter(movie -> movie.getId().equals(id))
                .findFirst();
    }

    /**
     * Retrieves all movies (optional helper, not strictly required but good for debugging).
     *
     * @return List of all movies.
     */
    public List<Movie> getAllMovies() {
        return new ArrayList<>(movies); // Return a copy to protect internal list
    }
}
