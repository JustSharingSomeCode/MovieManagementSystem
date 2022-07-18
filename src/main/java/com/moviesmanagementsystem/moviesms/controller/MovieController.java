package com.moviesmanagementsystem.moviesms.controller;

import com.moviesmanagementsystem.moviesms.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public String listMovies(Model model)
    {
        model.addAttribute("movies", movieService.getAllMovies());
        return "movies";
    }
}
