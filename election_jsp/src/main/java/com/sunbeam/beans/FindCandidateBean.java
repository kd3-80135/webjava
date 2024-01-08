package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class FindCandidateBean {
	private int candId;
	private Candidate candidate;
	
	public FindCandidateBean() {
	}

	public int getCandId() {
		return candId;
	}

	public void setCandId(int candId) {
		this.candId = candId;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	@Override
	public String toString() {
		return "FindCandidateBean [candId=" + candId + ", candidate=" + candidate + "]";
	}

	public FindCandidateBean(int candId, Candidate candidate) {
		this.candId = candId;
		this.candidate = candidate;
	}
	
	public void fetchCandidate () {
		try(CandidateDao cd = new CandidateDaoImpl()){
			this.candidate = cd.findById(candId);
			System.out.println(candidate.toString());
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	
}
