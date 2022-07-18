package com.moviesmanagementsystem.moviesms.repository;

import com.moviesmanagementsystem.moviesms.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
