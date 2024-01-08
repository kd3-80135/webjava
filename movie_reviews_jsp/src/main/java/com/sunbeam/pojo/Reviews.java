package com.sunbeam.pojo;


public class Reviews {
	private int id;
	private int movieId;
	private String review;
	private int rating;
	private int userId;
	private java.sql.Timestamp modified;
	
	public Reviews(int id, int movieId, String review, int rating, int userId, java.sql.Timestamp modified) {
		this.id = id;
		this.movieId = movieId;
		this.review = review;
		this.rating = rating;
		this.userId = userId;
		this.modified = modified;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getmovieId() {
		return movieId;
	}
	public void setmovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getuserId() {
		return userId;
	}
	public void setuserId(int userId) {
		this.userId = userId;
	}
	public java.sql.Timestamp getModified() {
		return modified;
	}
	public void setModified(java.sql.Timestamp modified) {
		this.modified = modified;
	}
	@Override
	public String toString() {
		return "Reviews [id=" + id + ", movieId=" + movieId + ", review=" + review + ", rating=" + rating
				+ ", userId=" + userId + ", modified=" + modified + "]";
	}
	
	
	
	
}
