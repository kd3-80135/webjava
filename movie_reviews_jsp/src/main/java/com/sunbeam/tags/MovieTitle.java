package com.sunbeam.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoInterface;
import com.sunbeam.pojo.Movies;

public class MovieTitle extends SimpleTagSupport{
	private int movieId;
		
	public MovieTitle() {
	}
	
	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	@Override
	public String toString() {
		return "MovieTitle [movieId=" + movieId + "]";
	}

	public MovieTitle(int movieId) {
		this.movieId = movieId;
	}

	@Override
	public void doTag() throws JspException, IOException {
		 Movies movies = null;
		 try(UserDaoInterface ud = new UserDao()){
			 movies = ud.findMovies(movieId);
		 }catch (Exception e) {
			 e.printStackTrace();
			 throw new RuntimeException(e);
		 }
		 
		 PageContext pageContext = (PageContext)this.getJspContext();
		 JspWriter out = pageContext.getOut();
		 
		 if (movies != null) {
			 out.println(movies.getTitle());
		 }
		 else {
			 out.println(".." + movieId + "..");
		 }
		 
		 
	}
}
