package com.voting.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.voting.dao.CandidateDao;
import com.voting.dao.CandidateDaoImpl;
import com.voting.pojos.Candidate;
import com.voting.pojos.User;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. set resp cont type
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		
		// 2. get writer : PW
		try (PrintWriter out = response.getWriter()) {
			out.print("Welcome voter - in candidate list page.....");
			out.print("Email " + request.getParameter("em"));
			
			/*
			 * get user details from the HttpSession n send it to the clnt OR in case of no
			 * session - send error mesg to the clnt
			 */
			// 1.Get HttpSession from WC
			
			System.out.println(getClass() + " session " + session.isNew());// false
			System.out.println(session.getId());// same
			
			// 2. Get user details from session
			User userDetails = (User) session.getAttribute("user_dtls");
			if (userDetails != null)
			{
				out.print("<h5>User details retrieved from Session " + userDetails + "</h5>");
				
				CandidateDao candidateDao = (CandidateDao) session.getAttribute("candidate_dao");
				
				if(userDetails.isStatus() == false) {
					try {
						List<Candidate> candidateList = candidateDao.getAllCandidate();
						
						for(Candidate candidate : candidateList) {
							System.out.println(candidate);
							
							out.append(candidate.toString());
							out.append("<br/>");
							out.flush();
						}
					} catch(Exception e) {
						throw new ServletException(e.getMessage(), e);
					}
					
				}
				
				//send logout link
				out.print("<h5> <a href='logout'>Log Me Out</a></h5>");
			
			} else {
				out.print("<h5> NO Session - no cookies or session expired!!!!</h5>");
			}

		}

	}

}
