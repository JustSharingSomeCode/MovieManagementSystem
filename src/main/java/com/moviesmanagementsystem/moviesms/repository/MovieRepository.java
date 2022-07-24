package com.moviesmanagementsystem.moviesms.repository;

import com.moviesmanagementsystem.moviesms.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Query("FROM Movie where name like %?1%")
    List<Movie> getMovieByName(String name);
}
