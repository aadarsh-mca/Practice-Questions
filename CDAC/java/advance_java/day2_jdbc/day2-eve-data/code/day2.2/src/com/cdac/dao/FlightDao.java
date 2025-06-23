package com.cdac.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.cdac.pojos.Flight;

public interface FlightDao {
//add a method to get available fligts
	List<Flight> getAvailableFlights(String src, String dest, 
			Date departureDate) throws SQLException;

	// add a method for clean up
	void cleanUp() throws SQLException;
}
