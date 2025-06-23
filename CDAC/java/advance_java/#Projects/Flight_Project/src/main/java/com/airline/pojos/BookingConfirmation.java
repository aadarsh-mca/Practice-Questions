package com.airline.pojos;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingConfirmation {
	
	int bookingId;
	
	// User Details
	int userId;
	
	// Flights Details
	int flightId;
	Flight flight;
	
	// Booking Details
	private int noOfPassenger;
	private int totalAmount;
	
//	public static BookingConfirmation getBookingDetails(ResultSet result) throws SQLException {
//		return new BookingConfirmation(0, 0, 0, null, 0, 0);
//		
////		return new BookingConfirmation(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), 
////				result.getInt(7), result.getString(8), result.getString(9), result.getString(10), result.getDate(11), result.getDate(12), result.getTime(13), result.getTime(14), result.getInt(15), result.getDouble(16), 
////				result.getInt(17), result.getInt(18));
//	}

	// Constructor
	public BookingConfirmation(int bookingId, int userId, int flightId, Flight flight, int noOfPassenger,
			int totalAmount) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.flightId = flightId;
		this.flight = flight;
		this.noOfPassenger = noOfPassenger;
		this.totalAmount = totalAmount;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public int getNoOfPassenger() {
		return noOfPassenger;
	}

	public void setNoOfPassenger(int noOfPassenger) {
		this.noOfPassenger = noOfPassenger;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
}
