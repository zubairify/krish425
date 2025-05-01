package com.krish.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.postgresql.Driver;

import com.krish.pojo.Flight;

public class FlightDaoImpl implements FlightDao {
	
	private Connection getConnection() throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/krish";
		
		DriverManager.registerDriver(new Driver());
		return DriverManager.getConnection(url, "krish", "postgre");
	}

	@Override
	public boolean save(Flight f) {
		String sql = "insert into flight values (?,?,?,?)";
		Connection conn = null;
		
		try {
			conn = getConnection();
			// Created a prepared or pre-compiled query
			PreparedStatement stmt = conn.prepareStatement(sql);
			// Replaced all the place-holders with data from flight object
			stmt.setInt(1, f.getCode());
			stmt.setString(2, f.getCarrier());
			stmt.setString(3, f.getSource());
			stmt.setString(4, f.getDestination());
			
			if(stmt.executeUpdate()>0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Flight> list() {
		String sql = "select * from flight";
		Connection conn = null;
		List<Flight> flights = new ArrayList<Flight>();
		
		try {
			conn = getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Flight f = new Flight();
				f.setCode(rs.getInt(1));
				f.setCarrier(rs.getString(2));
				f.setSource(rs.getString("source"));
				f.setDestination(rs.getString(4));
				
				flights.add(f);
			}
			return flights;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Flight findByCode(int code) {
		String sql = "select * from flight where code=" + code;
		Connection conn = null;
		
		try {
			conn = getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			Flight f = null;
			
			if(rs.next()) {
				f = new Flight();
				f.setCode(rs.getInt(1));
				f.setCarrier(rs.getString(2));
				f.setSource(rs.getString("source"));
				f.setDestination(rs.getString(4));
			}
			return f;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Flight> findByCarrier(String carrier) {
		String sql = "select * from flight where carrier=?";
		Connection conn = null;
		List<Flight> flights = new ArrayList<Flight>();
		
		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, carrier);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Flight f = new Flight();
				f.setCode(rs.getInt(1));
				f.setCarrier(rs.getString(2));
				f.setSource(rs.getString("source"));
				f.setDestination(rs.getString(4));
				
				flights.add(f);
			}
			return flights;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Flight> findByRoute(String source, String dest) {
		String sql = "select * from flight where source=? and destination=?";
		Connection conn = null;
		List<Flight> flights = new ArrayList<Flight>();
		
		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, source);
			stmt.setString(2, dest);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Flight f = new Flight();
				f.setCode(rs.getInt(1));
				f.setCarrier(rs.getString(2));
				f.setSource(rs.getString("source"));
				f.setDestination(rs.getString(4));
				
				flights.add(f);
			}
			return flights;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
