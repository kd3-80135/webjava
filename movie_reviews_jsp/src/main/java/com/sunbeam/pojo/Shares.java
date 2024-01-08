package com.sunbeam.pojo;

public class Shares {
	private int userId;
	private int reviewId;
	
	public Shares() {
		// TODO Auto-generated constructor stub
	}

	public Shares(int userId, int reviewId) {
		this.userId = userId;
		this.reviewId = reviewId;
	}

	public int getuserId() {
		return userId;
	}

	public void setuserId(int userId) {
		this.userId = userId;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	@Override
	public String toString() {
		return "Shares [userId=" + userId + ", reviewId=" + reviewId + "]";
	}
}
