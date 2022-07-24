package com.moviesmanagementsystem.moviesms.controller;

import com.moviesmanagementsystem.moviesms.model.Score;
import com.moviesmanagementsystem.moviesms.model.User;
import com.moviesmanagementsystem.moviesms.service.ScoreService;
import com.moviesmanagementsystem.moviesms.userdetails_service.CustomUserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ScoreController {

    private ScoreService scoreService;

    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @RequestMapping(value = "/scores/create", method = RequestMethod.POST)
    public String addScore(@ModelAttribute Score score, @AuthenticationPrincipal CustomUserDetails userDetails, RedirectAttributes redirectAttributes)
    {
        score.setUser_fk(userDetails.getId());

        System.out.println(score.getId());
        System.out.println(score.getUser_fk());
        System.out.println(score.getMovie_fk());
        System.out.println(score.getScore());
        System.out.println(score.getDetails());

        scoreService.saveScore(score);

        redirectAttributes.addAttribute("id", score.getMovie_fk());

        return "redirect:/movies/score/{id}";
    }
}
