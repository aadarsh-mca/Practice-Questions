package com.cdac.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * To supply mapping info to WC 
 * Use
 * Modern way - annotation 
 * OR 
 * Legacy 
 * XML tags
 */
@WebServlet("/hello")
/*
 * Run time annotation - meant for WC
 * When - @ web app deployment time
 * Using reflection , WC creates a Map
 * Key - /hello (URL Pattern)
 * Value -Fully qualified servlet class name
 * com.cdac.pages.HelloWorldServlet
 */
public class HelloWorldServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("in init "+Thread.currentThread());
	}
	
	@Override
	public void destroy() {
		System.out.println("in destroy "+Thread.currentThread());
	}
	@Override
	public void doGet(HttpServletRequest rq,HttpServletResponse resp) 
			throws ServletException,IOException {
		System.out.println("in do-get "+Thread.currentThread());
		//1 . set response content type
		/*
		 * Method of ServletRespone i/f
		 * public void setContentType (String contType)
		 * eg - text/html , application/json ....
		 */
		resp.setContentType("text/html");
		//2 . To send buffered char resp to the clnt , get Writer stream.
		/*
		 * Method of ServletResponse i/f
		 * public PrintWriter getWriter() throws IOException
		 */
		try(PrintWriter pw=resp.getWriter()) {
			pw.print("<h4> Welcome 2 Servlets at -  "
		+LocalDateTime.now()+"</h4>");
		}
		

	}

}
