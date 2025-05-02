package com.krish.service;

import java.util.List;

import com.krish.dao.FlightDao;
import com.krish.dao.FlightDaoImpl;
import com.krish.pojo.Flight;
import com.krish.util.InvalidFlightException;

public class FlightServiceImpl implements FlightService {
	private FlightDao dao;
	
	public FlightServiceImpl() {
		dao = new FlightDaoImpl();
	}
	
	@Override
	public boolean save(Flight f) {
		return dao.save(f);
	}

	@Override
	public List<Flight> list() {
		return dao.list();
	}

	@Override
	public Flight findByCode(int code) throws InvalidFlightException {
		Flight f = dao.findByCode(code);
		if(f == null)
			throw new InvalidFlightException("Invalid flight code: " + code);
		return f;
	}

	@Override
	public List<Flight> findByCarrier(String carrier) {
		return dao.findByCarrier(carrier);
	}

	@Override
	public List<Flight> findByRoute(String source, String dest) {
		return dao.findByRoute(source, dest);
	}

}
