package com.app.beans;

import java.util.List;

import com.app.dao.CandidateDaoImpl;
import com.app.dto.PartywiseVotes;
import com.app.entities.Candidate;

public class CandidateBean {
//depcy - dao layer
	private CandidateDaoImpl candidateDaoImpl;

	// default arg less constructor
	public CandidateBean()  {
		// create the depcy
		candidateDaoImpl = new CandidateDaoImpl();
		System.out.println("candidate bean created");
	}

	// add B.L method to get list of top 2 candidates
	public List<Candidate> listCandidates()  {
		return candidateDaoImpl.getTop2Candidates();// bean rets list of top 2 candidates -> JSP
	}

	// add B.L method to get party wise votes
	public List<PartywiseVotes> getPartyVotes()  {
		return candidateDaoImpl.getPartywiseVotes();
	}

}
