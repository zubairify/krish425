package com.krish.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.krish.util.MovieAlreadyExistException;
import com.krish.util.MovieNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MovieNotFoundException.class)
	public ResponseEntity<?> handleMovieNotFound(MovieNotFoundException e) {
		ErrorResponse error = ErrorResponse.create(e, HttpStatus.NOT_FOUND, e.getMessage());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MovieAlreadyExistException.class)
	public ResponseEntity<?> handleMovieAlreadyExist(MovieAlreadyExistException e) {
		ErrorResponse error = ErrorResponse.create(e, HttpStatus.BAD_REQUEST, e.getMessage());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
