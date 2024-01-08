package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.pojo.Movies;
import com.sunbeam.pojo.Review_Movie;
import com.sunbeam.pojo.Reviews;
import com.sunbeam.pojo.Shares;
import com.sunbeam.pojo.User;

public interface UserDaoInterface extends AutoCloseable{
	public int signUp(User u) throws Exception;
	public User findByEmail (String email) throws Exception;
	public User signIn (String email) throws Exception;
	public int editProfile (User u)throws Exception;
	public int chnagePassword(User u)throws Exception;
	public List<Movies> displayMovies () throws Exception;
	public int createReview (Reviews rv) throws Exception;
	public int editReview (Reviews rv, User u) throws Exception;
	public int deleteReview (int movie_id) throws Exception;
	public List<Review_Movie> displayAllReviews  () throws Exception;
	public List<Review_Movie> displayMyReviews  (User u) throws Exception;
//	public List<Reviews> displayMyReviews2  (User u) throws Exception;
//	public List<User> displayUser (User u) throws Exception;
	public int shareReviews (Shares s) throws Exception;
	public List<Review_Movie> displaySharedReviews (User u) throws Exception;
	public List<Reviews> displayAll  () throws Exception;
	public Movies findMovies (int movie_id) throws Exception;
	
}
