package org.videoclub;

import org.videoclub.controller.MovieController;
import org.videoclub.repository.MovieRepositoryImpl;
import org.videoclub.view.MovieView;

public class Main {
    public static void main(String[] args) {

        MovieRepositoryImpl movieRepository = new MovieRepositoryImpl();
        MovieController movieController = new MovieController(movieRepository);
        MovieView movieView = new MovieView(movieController);

         movieView.createMovieView();
        movieView.showMovies();
    }
}