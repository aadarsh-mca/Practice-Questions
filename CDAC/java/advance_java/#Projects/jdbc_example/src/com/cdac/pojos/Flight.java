package com.cdac.pojos;

import java.sql.Date;
import java.sql.Time;

public class Flight {
	
	/**
	 *  | flight_id      | int         | NO   | PRI | NULL    | auto_increment |
		| airline        | varchar(50) | NO   |     | NULL    |                |
		| source         | varchar(50) | NO   |     | NULL    |                |
		| destination    | varchar(50) | NO   |     | NULL    |                |
		| departure_date | date        | NO   |     | NULL    |                |
		| arrival_date   | date        | NO   |     | NULL    |                |
		| departure_time | time        | NO   |     | NULL    |                |
		| arrival_time   | time        | NO   |     | NULL    |                |
		| no_of_stops    | int         | NO   |     | 0       |                |
		| price          | double      |
	 */
	
	// flight_id | airline   | source    | destination | departure_date | arrival_date | departure_time | arrival_time | no_of_stops | price
	
	private int flightId;
	private String airline;
	private String source;	
	private String destination;
	private Date departureDate;
	private Date arrivalDate;
	private Time departureTime;
	private Time arrivalTime;
	private int noOfStops;
	private double price;
	
	
	public Flight(int flightId, String airline, String source, String destination, Date departureDate, Date arrivalDate,
			Time departureTime, Time arrivalTime, int noOfStops, double price) {
		super();
		this.flightId = flightId;
		this.airline = airline;
		this.source = source;
		this.destination = destination;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.noOfStops = noOfStops;
		this.price = price;
	}

	
	@Override
	public String toString() {
		return "Flight [ \n\tflightId = " + flightId + ", airline = " + airline + ", source = " + source + ", destination = "
				+ destination + ", \n\tdepartureDate = " + departureDate + ", arrivalDate = " + arrivalDate + ", departureTime = "
				+ departureTime + ", arrivalTime = " + arrivalTime + ", \n\tnoOfStops = " + noOfStops + ", price = " + price
				+ " ]";
	}
	
	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}


	public String getAirline() {
		return airline;
	}


	public void setAirline(String airline) {
		this.airline = airline;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public Date getDepartureDate() {
		return departureDate;
	}


	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}


	public Date getArrivalDate() {
		return arrivalDate;
	}


	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}


	public Time getDepartureTime() {
		return departureTime;
	}


	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}


	public Time getArrivalTime() {
		return arrivalTime;
	}


	public void setArrivalTime(Time arrivalTime) {
		this.arrivalTime = arrivalTime;
	}


	public int getNoOfStops() {
		return noOfStops;
	}


	public void setNoOfStops(int noOfStops) {
		this.noOfStops = noOfStops;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
	
}
