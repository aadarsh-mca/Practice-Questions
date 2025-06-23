package com.airline.pages;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.airline.dao.UserAccountDao;
import com.airline.pojos.User;

@WebServlet("/register")
public class RegisterUserPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		try {
			HttpSession session = request.getSession();
			UserAccountDao userAccountDao = (UserAccountDao) session.getAttribute("user-account-dao");
			
			String firstName = request.getParameter("first-name");
			String lastName = request.getParameter("last-name");
			String mobile = request.getParameter("mobile");
			String address = request.getParameter("address");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			User loggedInUser = userAccountDao.register(firstName, lastName, mobile, address, email, password);
			
			if(loggedInUser != null) {
				request.getSession().setAttribute("logged-in-user", loggedInUser);
				
				response.sendRedirect("book-flight");
			} else {
				// show incorrect email / password error
				response.sendRedirect("user-account.html");
			}
		} catch(Exception e) {
			throw new ServletException(e.getMessage(), e);
		}
	}

}
