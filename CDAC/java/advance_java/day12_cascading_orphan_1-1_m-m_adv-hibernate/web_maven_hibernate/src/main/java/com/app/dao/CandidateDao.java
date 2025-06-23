package com.app.dao;

import java.util.List;

import com.app.dto.PartywiseVotes;
import com.app.entities.Candidate;

public interface CandidateDao {

	// add a method to get top 2 candidates
	List<Candidate> getTop2Candidates();

	// add a method to get party wise votes
	List<PartywiseVotes> getPartywiseVotes();

}
