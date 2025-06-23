package com.cdac.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.cdac.pojos.Flight;
import static com.cdac.utils.DBUtils.*;

public class FlightDaoImpl implements FlightDao {
	private Connection connection;
	private PreparedStatement pst1;

	public FlightDaoImpl() throws SQLException {
		// open cn : singletin instance
		connection = openConnection();
		String sql1 = "select * from flights where source=? and destination=? and departure_date=? order by price";
		pst1 = connection.prepareStatement(sql1);
		System.out.println("flight dao created !");
	}

	@Override
	public List<Flight> getAvailableFlights(String src, String dest, Date departureDate) throws SQLException {
		List<Flight> flights = new ArrayList<>();
		// set IN params
		pst1.setString(1, src);
		pst1.setString(2, dest);
		pst1.setDate(3, departureDate);
		// exec query -> RST -> ORM -> List
		try (ResultSet rst = pst1.executeQuery()) {
			/*
			 * int flightId, String airline, String source, String destination,
			 *  Date departureDate, Date arrivalDate,
			Time departureTime, Time arrivalTime, 
			int noOfStops, double price
			 */
			while (rst.next())
				flights.add(new Flight(rst.getInt(1), rst.getString(2), src, 
						dest, departureDate, rst.getDate(6),
						rst.getTime(7),rst.getTime(8) , rst.getInt(9),rst.getDouble(10)));
		}
		return flights;
	}

	@Override
	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		closeConnection();
		System.out.println("flight dao cleaned up....");

	}

}
