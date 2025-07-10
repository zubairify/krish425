package com.krish.util;

public class MovieNotFoundException extends RuntimeException {

	public MovieNotFoundException() {
	}

	public MovieNotFoundException(String message) {
		super(message);
	}

}
