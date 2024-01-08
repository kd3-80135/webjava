package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class VotingBeans {
	private int candId;
	private int userId;
	private String message;
	
	public VotingBeans() {
	}
	
	public int getCandId() {
		return candId;
	}
	public void setCandId(int candId) {
		this.candId = candId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "VotingBeans [candId=" + candId + ", userId=" + userId + ", message=" + message + "]";
	}
	public VotingBeans(int candId, int userId, String message) {
		this.candId = candId;
		this.userId = userId;
		this.message = message;
	}
	
	public void voteCheck() {
		
		try(UserDao ud = new UserDaoImpl()){
			User user = ud.findById(userId);
			
			if (user.getStatus() != 0) {
				
				this.message = "You have already voted.";
				return;
			}
			try(CandidateDao cd = new CandidateDaoImpl()){
				int count = cd.incrementVote(candId);
				if (count ==  1) {
					count = ud.updateStatus(userId, true);
					if (count==1) {
						this.message = "Your vote has been registered successfully.";
					}
				}
				if (count == 0) {
					this.message = "Voting failed.";
				}	
			}	
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
