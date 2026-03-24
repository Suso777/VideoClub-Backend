package org.videoclub.view;

import org.videoclub.controller.MovieController;
import org.videoclub.model.Movie;

import java.util.List;
import java.util.Scanner;

public class MovieView {

    private MovieController movieController;

    public MovieView(MovieController movieController) {
        this.movieController = movieController;
    }

    public void createMovieView() {
        Movie movie = generateMovie();
        movieController.createMovieController(movie);
    }

    public Movie generateMovie() {
        Scanner scanner = new Scanner(System.in).useLocale(java.util.Locale.US);

        System.out.println("Escriba el título de la película: ");
        String titulo = scanner.nextLine();

        System.out.println("Escriba el director de la película: ");
        String director = scanner.nextLine();

        System.out.println("Escriba el género de la película: ");
        String genero = scanner.nextLine();

        System.out.println("Escriba el argumento de la película: ");
        String argumento = scanner.nextLine();

        System.out.println("Escriba la imagen de la película: ");
        String imagen = scanner.nextLine();

        System.out.println("Escriba la imagen del cartel de la película: ");
        String imageCartel = scanner.nextLine();

        System.out.println("Escriba el trailer de la película: ");
        String trailer = scanner.nextLine();

        Movie movie = new Movie(titulo, director, genero, argumento, imagen, imageCartel, trailer);

        scanner.close();

        return movie;
    }

    public void showMovies() {
        List<Movie> movieList = movieController.findAllController();

        for (Movie movie : movieList) {
            System.out.println("Título: " + movie.getTitulo() + " | Director: " + movie.getDirector() + " | Género: " + movie.getGenero() + " | Argumento: " + movie.getArgumento() + " | Imágen: " + movie.getImagen() + " | ImageCartel: " + movie.getImageCartel() + " | Trailer: " + movie.getTrailer());
        }
    }
}