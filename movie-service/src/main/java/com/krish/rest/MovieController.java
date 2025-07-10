package com.krish.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.krish.entity.Movie;
import com.krish.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	private MovieService service;
	
	@PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Movie> save(@RequestBody Movie m) {
		Movie mov = service.save(m);
		return new ResponseEntity<Movie>(mov, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/{movId}", produces = "application/json")
	public ResponseEntity<Movie> findById(@PathVariable int movId) {
		Movie mov = service.findById(movId);
		return new ResponseEntity<Movie>(mov, HttpStatus.FOUND); 
	}
	
	@GetMapping(value = "/all", produces = "application/json")
	public List<Movie> findAll() {
		return service.findAll();
	}
	
	@DeleteMapping(value = "/{movId}")
	public String delete(@PathVariable int movId) {
		service.delete(movId);
		return "Movie deleted";
	}
	
	@GetMapping(value = "/title/{title}", produces = "application/json")
	public Movie findByTitle(@PathVariable String title) {
		return service.findByTitle(title);
	}
	
	@GetMapping(value = "/genre/{genre}", produces = "application/json")
	public List<Movie> findByGenre(@PathVariable String genre) {
		return service.findByGenre(genre);
	}
	
	@GetMapping(value = "/rating", produces = "application/json")
	public List<Movie> findByRating(@RequestParam double min, @RequestParam double max) {
		return service.findByRatingBetween(min, max);
	}	
}
