package com.airline.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.airline.pojos.Flight;
import com.airline.utils.DBUtils;

public class FlightDaoImpl implements FlightDao {
	
	private Connection connection;
	private PreparedStatement allFlights, searchById, searchBySrcDestDate, searchBySrcDest, searchByDate, updateFlightDataStatement, deleteFlightStatement;
	
	private static FlightDaoImpl instance;
	
	private FlightDaoImpl() throws SQLException {
		connection = DBUtils.getInstance().getConnection();
		
		allFlights = connection.prepareStatement("Select * From flights");
		searchById = connection.prepareStatement("Select * From flights Where flight_id = ?");
		searchBySrcDestDate = connection.prepareStatement("Select * From flights Where source = ? AND destination = ? AND departure_date = ?");
		searchBySrcDest = connection.prepareStatement("Select * From flights Where source = ? AND destination = ?");
		searchByDate = connection.prepareStatement("Select * From flights Where departure_date = ?");
		
		updateFlightDataStatement = connection.prepareStatement("Update flights Set no_of_stops = ? AND arrival_time = ? Where flight_id = ?");
		deleteFlightStatement = connection.prepareStatement("Delete From flights Where airline = ? AND source = ? AND destination = ?");
		
		System.out.println("====== [ Flight DAO Created !!! ] ======");
	}
	
	public static FlightDaoImpl getInstance() throws SQLException {
		if(instance == null) {
			instance = new FlightDaoImpl();
		}
		return instance;
	}
	
	public void toggleAutoCommit() throws SQLException {
		connection.setAutoCommit(!connection.getAutoCommit());
		System.out.println("\n\t====== [ AutoCommit = " + connection.getAutoCommit() + " ] ======");
	}
	
	public void commit() throws SQLException {
		connection.commit();
		System.out.println("\n\t====== [ Commit SuccessFul ] ======");
	}
	
	public void callRollback() throws SQLException {
		connection.rollback();
		System.out.println("\n\t====== [ Rollback SuccessFul ] ======");
	}
	
	/**
	 * 
	 */
	private List<Flight> getAllFlights() throws SQLException {
		List<Flight> flightList = new ArrayList<>();
		
		try(ResultSet searchResult = allFlights.executeQuery()) {
			while(searchResult.next()) {
				Flight flight = Flight.getFlight(searchResult);
				
				flightList.add(flight);
			}
		}
		return flightList;
	}
	
	@Override
	public List<Flight> searchFlights() throws SQLException {
		return getAllFlights();
	}
	
	@Override
	public Flight searchFlights(int flightId) throws SQLException {
		// departure_date
		searchByDate.setInt(1, flightId);
		
		try(ResultSet searchResult = searchByDate.executeQuery()) {
			if(searchResult.next()) {
				Flight flight = Flight.getFlight(searchResult);
				return flight;
			}
		}
		return null;
	}
	
	@Override
	public List<Flight> searchFlights(String source, String destination, Date departureDate) throws SQLException {
		List<Flight> flightList = new ArrayList<>();
		
		// source    | destination | departure_date
		searchBySrcDestDate.setString(1, source);
		searchBySrcDestDate.setString(2, destination);
		searchBySrcDestDate.setDate(3, departureDate);
		
		try(ResultSet searchResult = searchBySrcDestDate.executeQuery()) {
			while(searchResult.next()) {
				Flight flight = Flight.getFlight(searchResult);
				
				flightList.add(flight);
			}
		}
		return flightList;
	}

	@Override
	public List<Flight> searchFlights(String source, String destination) throws SQLException {
		List<Flight> flightList = new ArrayList<>();
		
		// source    | destination
		searchBySrcDest.setString(1, source);
		searchBySrcDest.setString(2, destination);
		
		try(ResultSet searchResult = searchBySrcDest.executeQuery()) {
			while(searchResult.next()) {
				Flight flight = Flight.getFlight(searchResult);

				flightList.add(flight);
			}
		}
		return flightList;
	}

	@Override
	public List<Flight> searchFlights(Date departureDate) throws SQLException {
		List<Flight> flightList = new ArrayList<>();
		
		// departure_date
		searchByDate.setDate(1, departureDate);
		
		try(ResultSet searchResult = searchByDate.executeQuery()) {
			while(searchResult.next()) {
				Flight flight = Flight.getFlight(searchResult);
				
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
	public void cleanUp() throws SQLException, ClassNotFoundException {
		if(allFlights != null) allFlights.close();
			
		if (searchBySrcDestDate != null) {
			searchBySrcDestDate.close();
			searchBySrcDestDate = null;
		}

		if(searchBySrcDest != null) searchBySrcDest.close();
		if(searchByDate != null) searchByDate.close();

		if(updateFlightDataStatement != null) updateFlightDataStatement.close();
		if(deleteFlightStatement != null) deleteFlightStatement.close();
		
		DBUtils.getInstance().closeConnection();
		System.out.println("flight dao cleaned up !");
	}
}
