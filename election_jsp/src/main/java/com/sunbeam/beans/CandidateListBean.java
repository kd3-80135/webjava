package com.sunbeam.beans;

import java.util.List;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class CandidateListBean {
	private List<Candidate> list;
	
	public CandidateListBean() {
		
	}

	public List<Candidate> getList() {
		return list;
	}

	public void setList(List<Candidate> list) {
		this.list = list;
	}

	public CandidateListBean(List<Candidate> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "CandidateListBean [list=" + list + "]";
	}
	
	public void CandidateList() {
		try(CandidateDao cd = new CandidateDaoImpl()){
			this.list = cd.getCandidatewiseVotes();
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
	
	
}
