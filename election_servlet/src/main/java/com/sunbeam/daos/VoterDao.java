package com.sunbeam.daos;

import com.sunbeam.pojo.Voter;

public interface VoterDao extends AutoCloseable{
	Voter findByEmail(String email) throws Exception;
	Voter findById(int id) throws Exception;
	int save(Voter Voter) throws Exception;
	int updateStatus(int VoterId, boolean voted) throws Exception;
	int updatePassword(int VoterId, String newPassword) throws Exception;
	int deleteById(int id) throws Exception;
	int update(Voter Voter) throws Exception;
}
