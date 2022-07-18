package com.moviesmanagementsystem.moviesms.controller;

import com.moviesmanagementsystem.moviesms.model.Movie;
import com.moviesmanagementsystem.moviesms.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = "/movies/edit/{id}", method = RequestMethod.GET)
    public String movieDetails(@PathVariable int id, Model model)
    {
        Movie movie = movieService.getMovieById(id);

        model.addAttribute("movie", movie);

        return "admin/edit_movie";
    }

    @RequestMapping(value = "/movies/edit/{id}", method = RequestMethod.POST)
    public String editMovie(@PathVariable int id, @ModelAttribute Movie movie, Model model)
    {
        return "movies";
    }
}
