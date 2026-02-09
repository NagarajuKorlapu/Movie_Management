package com.example.movie.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for the root endpoint.
 */
@RestController
public class RootController {

    /**
     * GET /
     * Simple health check endpoint.
     */
    @GetMapping("/")
    public String healthCheck() {
        return "Movie Management API is running";
    }
}
