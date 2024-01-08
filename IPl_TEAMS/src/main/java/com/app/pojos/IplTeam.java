package com.app.pojos;

import javax.persistence.*;

@Entity@Table(name="Ipl_Team")
public class IplTeam {
	//hibernate id property must be serializable i.e it must implement serializable interface.
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)@Column(name="team_id", nullable=false, unique = true)
	private Integer teamId; 
	@Column(nullable=false, unique = true, length=50)
	private String name;
	@Column(nullable=false, unique = true, length=10)
	private String abbreviation;
	@Column(nullable=false, unique = false, length=50)
	private String owner;
	@Column(name = "max_age", nullable=false, unique = false, length=10)
	private int maxAge;
	@Column(name = "batting_avg", nullable=false, unique = false, length=10)
	private double battingAvg;
	@Column(name = "wickets_taken", nullable=false, unique = false, length=10)
	private int wicketsTaken;
	
	public IplTeam() {
	}
	
	public IplTeam(int teamId, String abbreviation) {
		this.teamId = teamId;
		this.abbreviation = abbreviation;
	}
	
	public IplTeam(String name, String abbreviation, String owner, int maxAge, double battingAvg, int wicketsTaken) {
		this.name = name;
		this.abbreviation = abbreviation;
		this.owner = owner;
		this.maxAge = maxAge;
		this.battingAvg = battingAvg;
		this.wicketsTaken = wicketsTaken;
	}


	public Integer getTeamId() {
		return teamId;
	}
	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getMaxAge() {
		return maxAge;
	}
	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}
	public double getBattingAvg() {
		return battingAvg;
	}
	public void setBattingAvg(double battingAvg) {
		this.battingAvg = battingAvg;
	}
	public int getWicketsTaken() {
		return wicketsTaken;
	}
	public void setWicketsTaken(int wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}
	@Override
	public String toString() {
		return "IplTeam [teamId=" + teamId + ", name=" + name + ", abbreviation=" + abbreviation + ", owner=" + owner
				+ ", maxAge=" + maxAge + ", battingAvg=" + battingAvg + ", wicketsTaken=" + wicketsTaken + "]";
	}
	
	
	
}
