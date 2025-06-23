package com.airline.dao;

import java.sql.SQLException;
import java.util.List;

import com.airline.pojos.BookingConfirmation;

public interface BookingConfirmationDao {
	
	boolean bookFlight(int userId, int flightId, int noOfPassenger, double flightPrice) throws SQLException;
	List<BookingConfirmation> fetchBooking(int userId) throws SQLException;
	
	void cleanUp() throws SQLException;
}
