package com.moviesmanagementsystem.moviesms.service;

import com.moviesmanagementsystem.moviesms.model.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getAllMovies();

    Movie getMovieById(int id);

    Movie saveMovie(Movie movie);

    Movie updateMovie(int id, Movie movie);

    void deleteMovieById(int id);
}
