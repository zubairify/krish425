package com.krish.dao;

import java.util.List;

import com.krish.pojo.Flight;

public interface FlightDao {

	boolean save(Flight f);
	
	List<Flight> list();
	
	Flight findByCode(int code);
	
	List<Flight> findByCarrier(String carrier);
	
	List<Flight> findByRoute(String source, String dest);
	
}
