package com.voting.dao;

import java.sql.SQLException;
import java.util.List;

import com.voting.pojos.Candidate;

public interface CandidateDao {
	
	List<Candidate> getAllCandidate() throws SQLException;
	void cleanUp() throws SQLException;
}
