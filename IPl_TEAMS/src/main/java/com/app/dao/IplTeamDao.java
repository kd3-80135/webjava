package com.app.dao;


import com.app.pojos.IplTeam;


public interface IplTeamDao {
	//add a method to add new team
	String addIplTeam(IplTeam newTeam);
	
	java.util.List<IplTeam> DisplayIdAbb ();
	IplTeam DisplayIplTeam (Integer teamId);
	java.util.List<IplTeam> DisplayTeamsByAgeWickets (int age, int wickets);
	int UpdateAgeBattingAvg (String team, int age, double avg);
	String DeleteTeam (int teamId);
}	
