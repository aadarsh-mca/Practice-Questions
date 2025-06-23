package com.airline.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

import com.airline.pojos.Flight;

public interface FlightDao {
		
		void toggleAutoCommit() throws SQLException;
		void callRollback() throws SQLException;
		
		List<Flight> searchFlights() throws SQLException;
		Flight searchFlights(int flightId) throws SQLException;
		List<Flight> searchFlights(String source, String destination, Date departureDate) throws SQLException;
		List<Flight> searchFlights(String source, String destination) throws SQLException;
		List<Flight> searchFlights(Date departureDate) throws SQLException;
		
		int updateFlightData(int flightId, int noOfStops, Time arrivalTime) throws SQLException;
		int deleteFlight(String airline, String source, String destination) throws SQLException;
		
		// cleanup
		void cleanUp() throws SQLException, ClassNotFoundException;
}
