package com.krish.service;

import java.util.List;

import com.krish.pojo.Flight;
import com.krish.util.InvalidFlightException;

public interface FlightService {

	boolean save(Flight f);

	List<Flight> list();

	Flight findByCode(int code) throws InvalidFlightException;

	List<Flight> findByCarrier(String carrier);

	List<Flight> findByRoute(String source, String dest);
}
