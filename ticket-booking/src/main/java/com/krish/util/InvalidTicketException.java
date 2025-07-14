package com.krish.util;

public class InvalidTicketException extends RuntimeException {

	public InvalidTicketException() {
	}

	public InvalidTicketException(String message) {
		super(message);
	}

}
