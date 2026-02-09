package com.example.movie.model;

/**
 * Represents a movie entity in the system.
 */
public class Movie {

    private Long id;
    private String name;
    private String description;
    private String genre;
    private Double rating;

    // Default constructor
    public Movie() {
    }

    // Parameterized constructor
    public Movie(Long id, String name, String description, String genre, Double rating) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.genre = genre;
        this.rating = rating;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                '}';
    }
}
