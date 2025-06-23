package com.voting.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(value = "/authenticate", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	@Override
	public void init() {
		System.out.println("====== [ init() called :: " + getClass() + "] ======");	
		// initialize DAO
	}

	@Override
	public void destroy() {
		System.out.println("====== [ destroy() called :: " + getClass() + "] ======");
		// clean up DAO
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		response.setContentType("text/html");
		
		System.out.println("====== [ doGet() called ] ======");
	
		try(PrintWriter out = response.getWriter()) {
			out.print("DAO Sign In Method :: <br/>Email : " + request.getParameter("em") + " <br/>Password : " + request.getParameter("pass"));
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		System.out.println("====== [ doPost() called ] ======");
		
		response.setContentType("text/html");
		
		try(PrintWriter out = response.getWriter()) {
			out.print("DAO Sign In Method :: <br/>Email : " + request.getParameter("em") + " <br/>Password : " + request.getParameter("pass"));
		}
		
	}

}
