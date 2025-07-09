package com.krish.service;

import java.util.List;

import com.krish.entity.Movie;

public interface MovieService {

	Movie save(Movie m);
	
	Movie findById(int movId);
	
	List<Movie> findAll();
	
	boolean delete(int movId);
}
