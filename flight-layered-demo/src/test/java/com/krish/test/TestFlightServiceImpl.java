package com.krish.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.krish.service.FlightService;
import com.krish.service.FlightServiceImpl;
import com.krish.util.InvalidFlightException;

public class TestFlightServiceImpl {

	private FlightService service;
	
	@BeforeEach
	public void init() {
		service = new FlightServiceImpl();
	}
	
	@Test
	void testSave() {
		
	}

	@Test
	void testList() {
		
	}

	@Test
	void testFindByCode(int code) throws InvalidFlightException {
		
	}
	
	@Test
	void testFindByInvalidCode(int code) {
		
	}

	@Test
	void testFindByCarrier(String carrier) {
		
	}

	@Test
	void testFindByRoute(String source, String dest) {
		
	}
}
