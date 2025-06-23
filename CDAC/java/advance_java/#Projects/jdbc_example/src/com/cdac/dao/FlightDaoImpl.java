package com.cdac.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.cdac.pojos.Flight;
import com.cdac.pojos.User;
import com.cdac.utils.DBUtils;

public class FlightDaoImpl implements FlightDao {
	
	private static boolean autocommit = true;
	private Connection connection;
	private PreparedStatement allFlights, availableFlightStatement, updateFlightDataStatement, deleteFlightStatement;
	
	public FlightDaoImpl() throws SQLException {
		// open cn
		connection = DBUtils.openConnection();
		
		// getting all flights
		allFlights = connection.prepareStatement("Select * From flights");
		
		// Display available flights in the asc order of price User  inputs
		availableFlightStatement = connection.prepareStatement("Select * From flights Where source = ? AND destination = ? AND departure_date = ? ORDER BY price ASC");
		
		// Updating the flight detail
		updateFlightDataStatement = connection.prepareStatement("Update flights Set no_of_stops = ? AND arrival_time = ? Where flight_id = ?");
		
		// Deleting the matching flight
		deleteFlightStatement = connection.prepareStatement("Delete From flights Where airline = ? AND source = ? AND destination = ?");
		
		System.out.println("flight dao created !");
	}
	
	public void toggleAutoCommit() throws SQLException {
		autocommit = !autocommit;
		connection.setAutoCommit(autocommit);
		System.out.println("\n\t====== [ AutoCommit = " + autocommit + " ] ======");
	}
	
	public void callRollback() throws SQLException {
		connection.rollback();
		System.out.println("\n\t====== [ Rollback SuccessFul ] ======");
	}
	
//	 flight_id | airline   | source    | destination | departure_date | arrival_date | departure_time | arrival_time | no_of_stops | price
	
	@Override
	public List<Flight> getAllFlights() throws SQLException {
		List<Flight> flightList = new ArrayList<>();
		
		try(ResultSet flights = allFlights.executeQuery()) {
			while(flights.next()) {
				Flight flight = new Flight(flights.getInt(1), flights.getString(2), flights.getString(3), flights.getString(4), 
						flights.getDate(5), flights.getDate(6), flights.getTime(7), flights.getTime(8), 
						flights.getInt(9), flights.getDouble(10));
				
				flightList.add(flight);
			}
		}
		return flightList;
	}
	
	@Override
	public List<Flight> getAvailableFlights(String source, String destination, Date departureDate) throws SQLException {
		List<Flight> flightList = new ArrayList<>();
		
		// source    | destination | departure_date
		availableFlightStatement.setString(1, source);
		availableFlightStatement.setString(2, destination);
		availableFlightStatement.setDate(3, departureDate);
		
		try(ResultSet flights = availableFlightStatement.executeQuery()) {
			while(flights.next()) {
				Flight flight = new Flight(flights.getInt(1), flights.getString(2), flights.getString(3), flights.getString(4), 
						flights.getDate(5), flights.getDate(6), flights.getTime(7), flights.getTime(8), 
						flights.getInt(9), flights.getDouble(10));
				
				flightList.add(flight);
			}
		}
		return flightList;
	}
	
	@Override
	public int updateFlightData(int flightId, int noOfStops, Time arrivalTime) throws SQLException {
		updateFlightDataStatement.setInt(1, noOfStops);
		updateFlightDataStatement.setTime(2, arrivalTime);
		updateFlightDataStatement.setInt(3, flightId);
		
		return updateFlightDataStatement.executeUpdate();
	}
	
	@Override
	public int deleteFlight(String airline, String source, String destination) throws SQLException {
		deleteFlightStatement.setString(1, airline);
		deleteFlightStatement.setString(2, source);
		deleteFlightStatement.setString(3, destination);
		
		return deleteFlightStatement.executeUpdate();
	}
	

	@Override
	public void cleanUp() throws SQLException {
		if(allFlights != null) allFlights.close();
			
		if (availableFlightStatement != null) {
			availableFlightStatement.close();
			availableFlightStatement = null;
		}

		if(updateFlightDataStatement != null) updateFlightDataStatement.close();
		if(deleteFlightStatement != null) deleteFlightStatement.close();
		
		DBUtils.closeConnection();
		System.out.println("user dao cleaned up !");
	}
}
