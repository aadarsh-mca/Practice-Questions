package com.airline.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.airline.pojos.Flight;

@WebServlet(value = "/flight-result")
public class FlightResultPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();  // false
		List<Flight> searchedFlights = (List<Flight>) session.getAttribute("searched-flights"); 
		
		try(PrintWriter out = response.getWriter()) {
			out.append("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7' crossorigin='anonymous'>");
			out.append("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js' integrity='sha384-k6d4wzSIapyDyv1kpU366/PK5hCdSbCRGRCMv+eplOQJWyd1fbcAu9OCUj5zNLiq' crossorigin='anonymous'></script>");
			out.append("<style>");
			out.append(".body { box-shadow: 0 20px 8px rgba(0, 0, 0, 0.2); }");
			out.append(".flight-table tr { padding: 5px 10px;}");
			out.append("</style>");
			
			out.append("<div class='table-container'>");
			out.append("<table style='border: 2px dashed blue;' class='flight-table table table-striped'>");
			
			// | flight_id | airline   | source      | destination | departure_date | arrival_date | departure_time | arrival_time | no_of_stops | price   |
			out.append("<thead class='thead-dark'> <tr>");
			out.append("<th>Flight No.</th>");
			out.append("<th>Airline</th>");
			out.append("<th>Source</th>");
			out.append("<th>Destination</th>");			
			out.append("<th>Departure Date</th>");
			out.append("<th>Arrival Date</th>");
			out.append("<th>Departure Time</th>");
			out.append("<th>Arrival Time</th>");
			out.append("<th>No of Stops</th>");
			out.append("<th>Price</th>");
			out.append("<th>Book Ticket</th>");
			out.append("</tr> </thead>");
			
			out.flush();
//			Thread.sleep(1000);
		
			out.append("<tbody>");
			
			if(searchedFlights != null) {
				for(Flight flight : searchedFlights) {
					out.append("<tr>");
					out.append(getFlightTableRow(flight));
					out.append("</tr>");
					
					out.flush();
				}
			}
			
			out.append("</tbody>");
			out.append("</table> </div>");
			out.flush();
		}
	}
	
	private String getFlightTableRow(Flight flight) {
		StringBuilder strb = new StringBuilder();
		
		strb.append("<td>" + flight.getFlightId() + "</td>");
		strb.append("<td>" + flight.getAirline() + "</td>");
		strb.append("<td>" + flight.getSource() + "</td>");
		strb.append("<td>" + flight.getDestination() + "</td>");
		strb.append("<td>" + flight.getDepartureDate() + "</td>");
		strb.append("<td>" + flight.getArrivalDate() + "</td>");
		strb.append("<td>" + flight.getDepartureTime() + "</td>");
		strb.append("<td>" + flight.getArrivalTime() + "</td>");
		strb.append("<td>" + flight.getNoOfStops() + "</td>");
		strb.append("<td>" + flight.getPrice() + "</td>");
		
		strb.append("<td><form action='book-flight' method='get'>");
		strb.append("<input type='hidden' name='flight-id' value='" + flight.getFlightId() + "' />");
		strb.append("<button type='submit' class='btn btn-outline-success'>Book Ticket</button>");
		strb.append("</td></form>");
		
		return strb.toString();
	}
	
}
