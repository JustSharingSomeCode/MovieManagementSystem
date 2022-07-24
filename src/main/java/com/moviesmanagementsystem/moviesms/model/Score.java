package com.moviesmanagementsystem.moviesms.model;

import javax.persistence.*;

@Entity
@Table(name = "scores")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int user_fk;
    private int movie_fk;
    private int score;
    private String details;


    @ManyToOne
    @JoinColumn(name = "user_fk", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;

    /*

    @ManyToOne
    private Movie movie;*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_fk() {
        return user_fk;
    }

    public void setUser_fk(int user_fk) {
        this.user_fk = user_fk;
    }

    public int getMovie_fk() {
        return movie_fk;
    }

    public void setMovie_fk(int movie_fk) {
        this.movie_fk = movie_fk;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
/*
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }*/
}
