package com.voting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.voting.pojos.Candidate;
import com.voting.utils.DBUtils;

public class CandidateDaoImpl implements CandidateDao {
	
	private Connection connection;
	private PreparedStatement allCandidateStatement;
	
	public CandidateDaoImpl() throws SQLException {
		connection = DBUtils.getConnection();
		
		allCandidateStatement = connection.prepareStatement("Select * From Candidates");
	}

	@Override
	public List<Candidate> getAllCandidate() throws SQLException {
		List<Candidate> candidateList = new ArrayList<>();
		
		try(ResultSet result = allCandidateStatement.executeQuery()) {
			while(result.next()) {
				Candidate candidate = new Candidate(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4));
				candidateList.add(candidate);
			}
		}
		return candidateList;
	}

	public void cleanUp() throws SQLException {
		if(allCandidateStatement != null) {
			allCandidateStatement.close();
			allCandidateStatement = null;
		}
	}
}
