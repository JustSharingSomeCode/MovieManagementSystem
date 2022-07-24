package com.moviesmanagementsystem.moviesms.controller;

import com.moviesmanagementsystem.moviesms.model.Movie;
import com.moviesmanagementsystem.moviesms.model.Score;
import com.moviesmanagementsystem.moviesms.service.MovieService;
import com.moviesmanagementsystem.moviesms.userdetails_service.CustomUserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public String listMovies(@RequestParam(value = "name", required = false) String name, Model model)
    {
        if (name != null && !name.equals(""))
        {
            model.addAttribute("movies", movieService.getMovieByName(name));
        }
        else {
            model.addAttribute("movies", movieService.getAllMovies());
        }
        return "movies";
    }

    @RequestMapping(value = "/movies/details/{id}", method = RequestMethod.GET)
    public String movieDetails(@PathVariable int id, Model model)
    {
        Movie movie = movieService.getMovieById(id);

        model.addAttribute("movie", movie);

        return "admin/edit_movie";
    }

    @RequestMapping(value = "/movies/edit/{id}", method = RequestMethod.POST)
    public String editMovie(@PathVariable int id, @ModelAttribute Movie movie, Model model)
    {
        movieService.updateMovie(id, movie);

        return "redirect:/movies";
    }

    @RequestMapping(value = "/movies/new", method = RequestMethod.GET)
    public String newMovie(Model model)
    {
        Movie movie = new Movie();

        model.addAttribute("movie", movie);

        return "admin/add_movie";
    }

    @RequestMapping(value = "/movies/create", method = RequestMethod.POST)
    public String addMovie(@ModelAttribute Movie movie)
    {
        movieService.saveMovie(movie);

        return "redirect:/movies";
    }

    @RequestMapping(value = "/movies/delete/{id}", method = RequestMethod.POST)
    public String deleteMovie(@PathVariable int id)
    {
        movieService.deleteMovieById(id);

        return "redirect:/movies";
    }

    @RequestMapping(value = "/movies/score/{id}", method = RequestMethod.GET)
    public String movieScore(@PathVariable int id, @AuthenticationPrincipal CustomUserDetails userDetails, Model model)
    {
        Movie movie = movieService.getMovieById(id);
        model.addAttribute("movie", movie);

        List<Score> scores = movie.getScores();
        model.addAttribute("scores", scores);

        double stars = 0;
        for (Score s : scores) {
            stars += s.getScore();
        }
        stars /= scores.size();

        model.addAttribute("stars", stars);

        if(userDetails != null) {
            for (Score s : scores) {
                if (s.getUser_fk() == userDetails.getId()) {
                    model.addAttribute("reviewed", true);
                    break;
                }
            }
        }

        Score score = new Score();
        model.addAttribute("review", score);

        System.out.println(score.getId());
        System.out.println(score.getUser_fk());
        System.out.println(score.getMovie_fk());
        System.out.println(score.getScore());
        System.out.println(score.getDetails());

        return "movie_score";
    }
}
