package com.airline.pages;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.airline.dao.FlightDao;
import com.airline.dao.FlightDaoImpl;
import com.airline.dao.UserAccountDao;
import com.airline.dao.UserAccountDaoImpl;
import com.airline.pojos.Flight;
import com.airline.utils.DBUtils;

/**
 * Servlet implementation class SearchFlightServlet
 */
@WebServlet(value = "/search-flight", loadOnStartup = 1)
public class SearchFlightPage extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private FlightDao flightDao;
	private UserAccountDao userAccountDao;
	
	@Override
	public void init() throws ServletException {
		System.out.println("====== [ Search-Flight init() ] ======");
		try {
			DBUtils.getInstance();
			flightDao = FlightDaoImpl.getInstance();
			userAccountDao = UserAccountDaoImpl.getInstance();
		} catch (Exception e) {
			throw new ServletException(e.getMessage(), e);
		}
	}

	@Override
	public void destroy() {
		System.out.println("====== [ Search-Flight destroy() ] ======");
		try {
			flightDao.cleanUp();
			userAccountDao.cleanUp();
			DBUtils.getInstance().closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		session.setAttribute("flight-dao", flightDao);
		session.setAttribute("user-account-dao", userAccountDao);
		
		List<Flight> availableFlights = null;
		
		/**
		 * Getting data from Search Form
		 * using URL query params
		 * ...
		 * Performing search query in SQL
		 * and getting data
		 */
		try {
			String source = request.getParameter("source");
			String destination = request.getParameter("destination");
			
			String date = request.getParameter("date");
			
			if(source.isBlank() == false && destination.isBlank() == false && date.isBlank() == false) {
				Date departureDate = Date.valueOf(date);
				availableFlights = flightDao.searchFlights(source, destination, departureDate);
				
			} else if(source.isBlank() == false && destination.isBlank() == false) {
				availableFlights = flightDao.searchFlights(source, destination);
			
			} else if(date.isBlank() == false) {
				Date departureDate = Date.valueOf(date);
				availableFlights = flightDao.searchFlights(departureDate);
				
			} else {
				availableFlights = flightDao.searchFlights();
			}
		} catch (Exception e) {
			throw new ServletException(e.getMessage(), e);
		}
		
		
		/**
		 * Sending SQL Data Result
		 * to display-flight page
		 */
		session.setAttribute("searched-flights", availableFlights);		
		
		response.sendRedirect("flight-result");
	}

//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
