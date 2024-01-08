package com.sunbeam.beans;

import java.util.List;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class ResultBean {
	private List<Candidate> list;
	
	public ResultBean() {
		
	}

	public List<Candidate> getList() {
		return list;
	}

	public void setList(List<Candidate> list) {
		this.list = list;
	}

	public ResultBean(List<Candidate> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "ResultBean [list=" + list + "]";
	}
	
	public void fetchResult () {
		try(CandidateDao cd = new CandidateDaoImpl()){
			list = cd.getCandidatewiseVotes();			
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
}
