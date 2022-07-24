package com.moviesmanagementsystem.moviesms.service.impl;

import com.moviesmanagementsystem.moviesms.model.Score;
import com.moviesmanagementsystem.moviesms.repository.ScoreRepository;
import com.moviesmanagementsystem.moviesms.service.ScoreService;
import org.springframework.stereotype.Service;

@Service
public class ScoreServiceImpl implements ScoreService {

    private ScoreRepository scoreRepository;

    public ScoreServiceImpl(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    @Override
    public Score saveScore(Score score) {
        return scoreRepository.save(score);
    }
}
