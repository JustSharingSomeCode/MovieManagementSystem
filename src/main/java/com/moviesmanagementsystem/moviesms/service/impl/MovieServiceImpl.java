package com.moviesmanagementsystem.moviesms.service.impl;

import com.moviesmanagementsystem.moviesms.model.Movie;
import com.moviesmanagementsystem.moviesms.repository.MovieRepository;
import com.moviesmanagementsystem.moviesms.service.MovieService;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(int id) {
        return movieRepository.findById(id).get();
    }

    @Override
    public List<Movie> getMovieByName(String name) {
        return movieRepository.getMovieByName(name);
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovie(int id, Movie movie) {

        Movie ref = movieRepository.getReferenceById(id);
        ref.setName(movie.getName());
        ref.setDescription(movie.getDescription());
        ref.setRating(movie.getRating());
        ref.setDuration(movie.getDuration());
        ref.setImg_url(movie.getImg_url());

        return movieRepository.save(ref);
    }

    @Override
    public void deleteMovieById(int id) {
        movieRepository.deleteById(id);
    }
}
