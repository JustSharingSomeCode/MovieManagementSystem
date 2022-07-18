package com.moviesmanagementsystem.moviesms.repository;

import com.moviesmanagementsystem.moviesms.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, Integer> {
}
