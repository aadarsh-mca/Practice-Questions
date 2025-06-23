package com.voting.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.voting.dao.UserDao;
import com.voting.dao.UserDaoImpl;
import com.voting.pojos.User;

import static com.voting.utils.DBUtils.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(value = "/authenticate", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;

	/**
	 * @see Servlet#init()
	 */
	// overriding form of the method can't add any new | broader checked excs
	public void init() throws ServletException {
		System.out.println("in init " + getClass());
		try {
			// open connection
			openConnection();
			// create dao instance
			userDao = new UserDaoImpl();
			System.out.println(getClass() + " inited !");
		} catch (Exception e) {
			System.out.println(e);
			// centralized exc handling in servlets
			// re throw the same exc to WC , by wrapping it in ServletException
			throw new ServletException("err in init", e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("in destroy " + getClass());
		// dao's clean up
		try {
			userDao.cleanUp();
		} catch (Exception e) {
			System.out.println(e);
			// how to inform WC about the exc?
			throw new RuntimeException("err in destroy", e);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in do-post" + getClass());
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			// get request data - email n password
			String email = request.getParameter("em");
			String pwd = request.getParameter("pass");
			// invoke dao's method for sign in
			User user = userDao.signIn(email, pwd);
			// null checking
			if (user != null) {
				// valid login -> send success resp
				pw.print("<h5> Login Success </h5>");
				pw.print("<h6> Hello , " + user.getFirstName() + " " + user.getLastName() + "</h6>");
			} else {
				// invalid login
				pw.print("<h5>Invalid Login , Pls <a href='login.html'>Retry</a></h5>");
			}

		} catch (Exception e) {
			// re throw exc to the caller - WC
			throw new ServletException("err in do-post", e);
		}
	}

}
