package org.videoclub.repository;

import org.videoclub.config.DBManager;
import org.videoclub.model.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieRepositoryImpl {

    private Connection connection;

    public void createMovie(Movie movie) {
        String querySQLCreate = "INSERT INTO movies (titulo, director, genero, argumento, imagen, imageCartel, trailer) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            connection = DBManager.initConnection();
            PreparedStatement statement = connection.prepareStatement(querySQLCreate);
            statement.setString(1, movie.getTitulo());
            statement.setString(2, movie.getDirector());
            statement.setString(3, movie.getGenero());
            statement.setString(4, movie.getArgumento());
            statement.setString(5, movie.getImagen());
            statement.setString(6, movie.getImageCartel());
            statement.setString(7, movie.getTrailer());
            statement.execute();
            System.out.println("Película Creada");

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            DBManager.closeConnection();
        }
    }

    public List<Movie> findAll() {
        List<Movie> movies = new ArrayList<>();
        String querySQLSelectAll = "SELECT * FROM movies";
        try {
            connection = DBManager.initConnection();
            PreparedStatement statement = connection.prepareStatement(querySQLSelectAll);
            ResultSet response = statement.executeQuery();
            while (response.next()) {
                String titulo = response.getString("titulo");
                String director = response.getString("director");
                String genero = response.getString("genero");
                String argumento = response.getString("argumento");
                String imagen = response.getString("imagen");
                String imageCartel = response.getString("imageCartel");
                String trailer = response.getString("trailer");
                Movie movie = new Movie(titulo, director, genero, argumento, imagen, imageCartel, trailer);
                movies.add(movie);
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            DBManager.closeConnection();
        }
        return movies;
    }
}
