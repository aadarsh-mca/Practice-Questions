package com.cdac.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

import com.cdac.pojos.Flight;

public interface FlightDao {
		
		// auto-commit
		void toggleAutoCommit() throws SQLException;
		
		// rollback
		void callRollback() throws SQLException;
		
		// getting all flights
		List<Flight> getAllFlights() throws SQLException;
		
		// getting all available flights
		List<Flight> getAvailableFlights(String source, String destination, Date departureDate) throws SQLException;
		
		// updating the flight details
		int updateFlightData(int flightId, int noOfStops, Time arrivalTime) throws SQLException;

		// deleting the flight 
		int deleteFlight(String airline, String source, String destination) throws SQLException;
		
		// cleanup
		void cleanUp() throws SQLException;
}
