package com.airline.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.airline.pojos.User;

@WebServlet("/book-flight")
public class BookFlightPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		System.out.println("Flight Selected :: " + request.getParameter("flight-id"));

		HttpSession session = request.getSession(false);
		Object userObject = session.getAttribute("logged-in-user");
		
		if(userObject == null) {
//			RequestDispatcher requestDispatcher = request.getRequestDispatcher("user-account.html");
//			requestDispatcher.forward(request, response);
			
			response.sendRedirect("user-account.html");
		} else {
//			RequestDispatcher requestDispatcher = request.getRequestDispatcher("book-flight");
//			requestDispatcher.forward(request, response);
			
			User loggedInUser = (User) session.getAttribute("logged-in-user");
			System.out.println("User :: " + loggedInUser);
			
			response.sendRedirect("booking-confirmation");
		}
	}

}
