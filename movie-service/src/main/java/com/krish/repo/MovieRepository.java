package com.krish.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krish.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
