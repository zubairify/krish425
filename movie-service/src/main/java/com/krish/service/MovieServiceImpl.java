package com.krish.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krish.entity.Movie;
import com.krish.repo.MovieRepository;
import com.krish.util.MovieAlreadyExistException;
import com.krish.util.MovieNotFoundException;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository repo;
	
	@Override
	public Movie save(Movie m) {
		if(repo.existsById(m.getMovId()))
			throw new MovieAlreadyExistException("Movie already exist with Id: " + m.getMovId());
		return repo.save(m);
	}

	@Override
	public Movie findById(int movId) {
		return repo.findById(movId).orElseThrow(
				() -> new MovieNotFoundException("Movie not found with Id: " + movId));
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

	@Override
	public Movie findByTitle(String title) {
		return repo.findByTitle(title).orElseThrow(
				() -> new MovieNotFoundException("Movie no found with title: " + title));
	}

	@Override
	public List<Movie> findByGenre(String genre) {
		return repo.findByGenre(genre);
	}

	@Override
	public List<Movie> findByRatingBetween(double min, double max) {
		return repo.findByRatingBetween(min, max);
	}
}
