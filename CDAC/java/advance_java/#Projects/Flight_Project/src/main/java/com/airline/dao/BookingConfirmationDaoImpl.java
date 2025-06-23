package com.airline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.airline.pojos.BookingConfirmation;
import com.airline.pojos.Flight;
import com.airline.pojos.User;
import com.airline.utils.DBUtils;

public class BookingConfirmationDaoImpl implements BookingConfirmationDao {
	
	private Connection connection;
	private UserAccountDao userAccountDao;
	private FlightDao flightDao;
	private PreparedStatement bookFlight, fetchBooking;
	
	private static BookingConfirmationDaoImpl instance;
	
	public static BookingConfirmationDaoImpl getInstance() throws SQLException {
		if(instance == null) {
			instance = new BookingConfirmationDaoImpl();
		}
		return instance;
	}
	
	private BookingConfirmationDaoImpl() throws SQLException {
		connection = DBUtils.getInstance().getConnection();
		userAccountDao = UserAccountDaoImpl.getInstance();
		flightDao = FlightDaoImpl.getInstance();
		
		bookFlight = connection.prepareStatement("Insert into Flight_Booking_Confirmation Values (?, ?, ?, ?)");
		fetchBooking = connection.prepareStatement("Select * From Flight_Booking_Confirmation Where user_id = ?");
		
		
//		StringBuilder bookFlightQuery = new StringBuilder();
//		bookFlightQuery.append("Select u.id, u.first_name, u.last_name, u.mobile, u.address, u.email,");
//		bookFlightQuery.append("f.flight_id, f.airline, f.source, f.destination, f.departure_date, f.arrival_date, f.departure_time, f.arrival_time, f.no_of_stop, f.price,");
//		bookFlightQuery.append("b.no_of_passenger, b.total_amount");
//		bookFlightQuery.append("From Flight_Booking_Confirmation as b");
//		bookFlightQuery.append("Inner Join Flight_Users as u");
//		bookFlightQuery.append("On b.user_id = u.id");
//		bookFlightQuery.append("Inner Join Flights as f");
//		bookFlightQuery.append("On b.flight_id = f.flight_id");
//		
//		fetchBooking = connection.prepareStatement(bookFlightQuery.toString());
//
//		bookFlight = connection.prepareStatement(""
//				+ "Select u.id, u.first_name, u.last_name, u.mobile, u.address, u.email, "
//				+ "f.flight_id, f.airline, f.source, f.destination, f.departure_date, f.arrival_date, f.departure_time, f.arrival_time, f.no_of_stop, f.price, "
//				+ "b.no_of_passenger, b.total_amount "
//				+ "From Flight_Booking_Confirmation as b"
//				+ "Inner Join Flight_Users as u"
//				+ "On b.user_id = u.id"
//				+ "Inner Join Flights as f"
//				+ "On b.flight_id = f.flight_id");
	}
	
	@Override
	public boolean bookFlight(int userId, int flightId, int noOfPassenger, double flightPrice) throws SQLException {
		int totalAmount = (int) Math.round(noOfPassenger * flightPrice);
		
		bookFlight.setInt(1, userId);
		bookFlight.setInt(2, flightId);
		bookFlight.setInt(3, noOfPassenger);
		bookFlight.setInt(4, totalAmount);
		
		if(bookFlight.executeUpdate() == 1) {
			return true;
		}
		return false;
	}

	@Override
	public List<BookingConfirmation> fetchBooking(int userId) throws SQLException {
		List<BookingConfirmation> listOfBookings = null;
		
		fetchBooking.setInt(1, userId);
		
		try(ResultSet result = fetchBooking.executeQuery()) {
			User user = null;
			
			while(result.next()) {
				int bookingId = result.getInt(1);
				int flightId = result.getInt(3);
				int noOfPassenger = result.getInt(4);
				int totalAmount = result.getInt(5);
				
				if(user == null) {
					user = userAccountDao.getUser(userId);
				}
				
				Flight flight = flightDao.searchFlights(flightId);
				
				BookingConfirmation bookingConfirmation = new BookingConfirmation(bookingId, userId, flightId, flight, noOfPassenger, totalAmount);
				
				listOfBookings.add(bookingConfirmation);
			}
		}
		return listOfBookings;
	}

	@Override
	public void cleanUp() throws SQLException {
		if(fetchBooking != null) fetchBooking.close();
	}

}
