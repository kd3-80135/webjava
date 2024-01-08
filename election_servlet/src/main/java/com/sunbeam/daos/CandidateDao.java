package com.sunbeam.daos;

import java.util.List;

import com.sunbeam.pojo.Candidate;

public interface CandidateDao extends AutoCloseable {
	public int save(Candidate c) throws Exception;
	public int deleteById(int id) throws Exception;	
	public int update(Candidate c) throws Exception;
	public List<Candidate> findAll() throws Exception;
	public int incrementVote(int candidateId) throws Exception;
	public List<Candidate> findByParty(String givenParty) throws Exception;
	public List<Candidate> getCandidatewiseVotes() throws Exception;
}
