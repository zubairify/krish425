package com.krish.util;

public class MovieAlreadyExistException extends RuntimeException {

	public MovieAlreadyExistException() {
	}

	public MovieAlreadyExistException(String message) {
		super(message);
	}
}
