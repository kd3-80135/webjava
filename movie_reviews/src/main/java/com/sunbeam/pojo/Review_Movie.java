package com.sunbeam.pojo;

import java.sql.Timestamp;

public class Review_Movie {
	private int movie_id;
	private int review_id;
	private String review;
	private int rating;
	private Timestamp modified;
	private String title;
	private int user_id;
	
	public Review_Movie() {
		
	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public int getReview_id() {
		return review_id;
	}

	public void setReview_id(int review_id) {
		this.review_id = review_id;
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

	public Timestamp getModified() {
		return modified;
	}

	public void setModified(Timestamp modified) {
		this.modified = modified;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "Review_Movie [movie_id=" + movie_id + ", review_id=" + review_id + ", review=" + review + ", rating="
				+ rating + ", modified=" + modified + ", title=" + title + ", user_id=" + user_id + "]";
	}

	public Review_Movie(int review_id, int movie_id, String review, int rating, Timestamp modified, String title,
			int user_id) {
		this.movie_id = movie_id;
		this.review_id = review_id;
		this.review = review;
		this.rating = rating;
		this.modified = modified;
		this.title = title;
		this.user_id = user_id;
	}

	
	
	
	
}