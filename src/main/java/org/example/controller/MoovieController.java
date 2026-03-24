package org.videoclub.controller;

import org.videoclub.model.Movie;
import org.videoclub.repository.MovieRepositoryImpl;
import java.util.List;

public class MovieController {

    private MovieRepositoryImpl movieRepository;

    public MovieController(MovieRepositoryImpl movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void createMovieController(Movie movie) {
        movieRepository.createMovie(movie);
    }

    public List<Movie> findAllController() {
        return movieRepository.findAll();
    }
}
