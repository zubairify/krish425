package com.krish.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krish.entity.Movie;
import com.krish.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	private MovieService service;
	
	@PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
	public Movie save(@RequestBody Movie m) {
		return service.save(m);
	}
	
	@GetMapping(value = "/{movId}", produces = "application/json")
	public Movie findById(@PathVariable int movId) {
		return service.findById(movId);
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
}
