package com.app.dao;

import static com.app.utils.HibernateUtils.getFactory;

import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.dto.PartywiseVotes;
import com.app.entities.Candidate;

public class CandidateDaoImpl implements CandidateDao {

	@Override
	public List<Candidate> getTop2Candidates() {
		List<Candidate> candidates = null;
		// 1. get session from SF (getCurrentSession)
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}
		return candidates;
	}

	@Override
	public List<PartywiseVotes> getPartywiseVotes() {
		List<PartywiseVotes> list = null;
		// 1. get session from SF (getCurrentSession)
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {

			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}
		return list;
	}

}
