package com.sunbeam.pojo;

public class Candidate {
	private int id;
	private String name;
	private int votes;
	private String party;
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
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	@Override
	public String toString() {
		return "Candidate [id=" + id + ", name=" + name + ", votes=" + votes + ", party=" + party + "]";
	}
	public Candidate(int id, String name, String party, int votes) {
		this.id = id;
		this.name = name;
		this.votes = votes;
		this.party = party;
	}
	
	public Candidate() {	
	}
	
}