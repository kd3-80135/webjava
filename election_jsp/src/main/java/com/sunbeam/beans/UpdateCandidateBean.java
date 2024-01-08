package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class UpdateCandidateBean {
	private int id;
	private String name;
	private String party;
	private int votes;
	private String message;
	
	public UpdateCandidateBean() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "UpdateCandidateBean [id=" + id + ", name=" + name + ", party=" + party + ", votes=" + votes
				+ ", message=" + message + "]";
	}
	public UpdateCandidateBean(int id, String name, String party, int votes, String message) {
		this.id = id;
		this.name = name;
		this.party = party;
		this.votes = votes;
		this.message = message;
	}
	
	public void updateCandidate() {
		try(CandidateDao cd = new CandidateDaoImpl()){
			Candidate c = new Candidate(id, name, party, votes);
			int count = cd.update(c);
			this.message = "Candidates Updated : " + count;
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
	
	

}
