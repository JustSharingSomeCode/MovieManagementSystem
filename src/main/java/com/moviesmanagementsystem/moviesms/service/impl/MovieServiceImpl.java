package com.moviesmanagementsystem.moviesms.service.impl;

import com.moviesmanagementsystem.moviesms.model.Movie;
import com.moviesmanagementsystem.moviesms.repository.MovieRepository;
import com.moviesmanagementsystem.moviesms.service.MovieService;
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
}
