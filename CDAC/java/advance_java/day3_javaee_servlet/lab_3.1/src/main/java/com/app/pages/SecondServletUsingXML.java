package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServletUsingXML extends HttpServlet {
	
	@Override
	public void init() {
		System.out.println("====== [ init() called \n\tClass :: " + getClass() + "\n\tThred :: " + Thread.currentThread() + " ] ======");
	}
	
	@Override
	public void destroy() {
		System.out.println("====== [ destroy() called \n\tClass :: " + getClass() + "\n\tThred :: " + Thread.currentThread() + " ] ======");
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("====== [ doGet() called -- fetching data using  \n\tClass :: " + getClass() + "\n\tThred :: " + Thread.currentThread() + " ] ======");		
		
		// Clarify the content/response type
		resp.setContentType("text/html");
		
		// show 
		try(PrintWriter out = resp.getWriter()) {
			out.write("<h1 align='center'>Inside Second Page !!!</h1><br/>");
		}	
	}

}
