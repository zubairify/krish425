package com.krish.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krish.entity.Movie;
import com.krish.repo.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository repo;
	
	@Override
	public Movie save(Movie m) {
		return repo.save(m);
	}

	@Override
	public Movie findById(int movId) {
		return repo.findById(movId).orElse(null);
	}

	@Override
	public List<Movie> findAll() {
		return repo.findAll();
	}

	@Override
	public boolean delete(int movId) {
		repo.deleteById(movId);
		return true;
	}
}
