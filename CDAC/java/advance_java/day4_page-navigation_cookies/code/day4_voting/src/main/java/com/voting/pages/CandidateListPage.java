package com.voting.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CandidateListPage
 */
@WebServlet("/list")
public class CandidateListPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. set resp cont type
		response.setContentType("text/html");
		// 2. get writer : PW
		try (PrintWriter pw = response.getWriter()) {
			pw.print("Welcome voter - in candidate list page.....");
			pw.print("Email " + request.getParameter("em"));
			/*
			 * get user details from the cookie n send it to the clnt OR in case of no
			 * cookies - send error mesg to the clnt
			 */
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				// cookies - present
				for (Cookie c : cookies) {
					if (c.getName().equals("user_details")) {
						pw.print("<h5> User Details from Cookie " + c.getValue() + "</h5>");
					}
				}

			} else
				pw.print("<h5>No Cookies , Can't remember the client !!!!!>/h5>");

		}

	}

}
