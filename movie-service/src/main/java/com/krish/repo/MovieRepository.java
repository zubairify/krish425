package com.krish.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krish.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

	Optional<Movie> findByTitle(String title);
	
	List<Movie> findByGenre(String genre);
	
	List<Movie> findByRatingBetween(double min, double max);
	
}
