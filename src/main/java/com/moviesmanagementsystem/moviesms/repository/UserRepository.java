package com.moviesmanagementsystem.moviesms.repository;

import com.moviesmanagementsystem.moviesms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
