package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Mapping the servlet with url pattern
@WebServlet(value = "/first-page", loadOnStartup = 2)
public class FirstServletUsingAnnotation extends HttpServlet {
	
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
			out.write("<h1 align='center'>Inside First Page !!!</h1><br/>");
			out.write("<h1 id='timestamp' align='center'>====== [ " + LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute() + ":" + LocalDateTime.now().getSecond() + " ] ======</h1><br/>");
//			
			String script = "<script>"
					+ "function getCurrTimeString() {"
					+ "		curDate = new Date();"
					+ "		var hour = formatTime(curDate.getHours());"
					+ "		var minute = formatTime(curDate.getMinutes());"
					+ "		var second = formatTime(curDate.getSeconds());"
					+ "		return `${hour}:${minute}:${second}`;"
					+ "}"
					+ "function formatTime(timeDetail) {"
					+ "		if(timeDetail <= 9) return `0${timeDetail}`;"
					+ "		return timeDetail;"
					+ "}"
					+ "function btnClick() {"
					+ "		document.getElementById('timestamp').innerHTML = `====== [ ${getCurrTimeString()} ] ======`;"
					+ "}"
					+ "setInterval("
					+ "		() => {"
					+ "			document.getElementById('timestamp').innerHTML = `====== [ ${getCurrTimeString()} ] ======`;"
					+ "		}, 1000);"
					+ "</script>";
			
			out.write(script);			
			out.flush();
		}
	}

}
