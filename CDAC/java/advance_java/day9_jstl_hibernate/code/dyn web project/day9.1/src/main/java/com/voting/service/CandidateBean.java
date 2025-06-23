package com.voting.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.voting.dao.CandidateDao;
import com.voting.dao.CandidateDaoImpl;
import com.voting.pojos.Candidate;

public class CandidateBean {
	//props
	//dependency
	private CandidateDao candidateDao;
	public CandidateBean() throws SQLException{
		// create dao instance
		candidateDao=new CandidateDaoImpl();
		System.out.println("candidate bean created !");
	}
	public CandidateDao getCandidateDao() {
		return candidateDao;
	}
	public void setCandidateDao(CandidateDao candidateDao) {
		this.candidateDao = candidateDao;
	}
	//B.L method to get top 2 candidates
	public List<Candidate> getTopCandidates() throws SQLException{
		System.out.println("in B.L - in top 2 ");
		return candidateDao.getTop2Candidates();
	}
	//B.L method to  get party wise votes
	public Map<String, Integer> fetchResults() throws SQLException{
		System.out.println("in B.L - partywise votes");
		return candidateDao.getPartyWiseVotes();
	}
	

}
