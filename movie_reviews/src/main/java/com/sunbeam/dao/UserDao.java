package com.sunbeam.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.pojo.Movies;
import com.sunbeam.pojo.Review_Movie;
import com.sunbeam.pojo.Reviews;
import com.sunbeam.pojo.Shares;
import com.sunbeam.pojo.User;
import com.sunbeam.util.DateUtill;

public class UserDao extends Dao implements UserDaoInterface{
	public UserDao () throws Exception
	{	
	}
	
	public int signUp(User u) throws Exception{
		String sql = "INSERT INTO users VALUES(default,?,?,?,?,?,?)";
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, u.getFirstName());
			stmt.setString(2, u.getLastName());
			stmt.setString(3, u.getEmail());
			stmt.setString(4, u.getMobile());
			stmt.setDate(5, DateUtill.utilToSqlDate(u.getBirth()));
			stmt.setString(6, u.getPassword());
			int count = stmt.executeUpdate();
			return count;
		}
	}
	
	public User findByEmail(String email) throws Exception{
		String sql = "select * from users where email = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, email);
			try (ResultSet rs = stmt.executeQuery()){
				while (rs.next()) {
					User us = new User(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("password"), null, null);
					return us;
				}
			}
		}
		return null;	
	}
	
	
	public User signIn (String email) throws Exception{
		String sql = "select email,password,id from users where email = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, email);
			try (ResultSet rs = stmt.executeQuery()){
				while (rs.next()) {
					String email1 = rs.getString("email");
					String pass = rs.getString("password");
					int user_id = rs.getInt("id");
					User u = new User();
					u.setEmail(email1);
					u.setPassword(pass);
					u.setId(user_id);
					
					return u;
				}
			}
		}
		return new User();
	}
	
	public int editProfile (User u)throws Exception{
				String sql = "update users set first_name =?, last_name =?, mobile=?, birth=?, password=? where email=?";
				try(PreparedStatement stmt = con.prepareStatement(sql)) 
				{
					stmt.setString(1, u.getFirstName());
					stmt.setString(1, u.getLastName());
					stmt.setString(1, u.getPassword());
					stmt.setString(1, u.getMobile());
					stmt.setDate(1,DateUtill.utilToSqlDate(u.getBirth()));
					stmt.setString(2, u.getEmail());
					int count=stmt.executeUpdate();
					return count;	
				}
	}
	
	public int chnagePassword (User u) throws Exception {
		String sql = "update users set password=? where email=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, u.getPassword());
			stmt.setString(2, u.getEmail());
			int count = stmt.executeUpdate();
			return count;
		}
	}
	
	public List<Movies> displayMovies () throws Exception
	{
		List<Movies> l = new ArrayList<Movies>();
		String sql="select * from movies";
		try(PreparedStatement stmt = con.prepareStatement(sql))
		{
			try(ResultSet rs= stmt.executeQuery())
			{
				while(rs.next())
				{
					String title= rs.getString("title");
					int id = rs.getInt("id");
					Date sdate = rs.getDate("rel_date");
					Movies m = new Movies(id, title, sdate);
					l.add(m);
				}
			}
		}
		return l;
	}
	
	
	
	public List<Movies> displayNonEditedMovies (User u) throws Exception{
		List<Movies> l = new ArrayList<>();
		String sql = "select m.movie_id,title from movies m left outer join reviews r on m.movie_id = r.movie_id and r.user_id =? where r.review is null";
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, u.getId());
			try (ResultSet rs = stmt.executeQuery()){
				while (rs.next()) {
					Movies m = new Movies(rs.getInt("movie_id"), rs.getString("title"), null);
					l.add(m);
				}
			}
		}
		return l;
	}
	
	
	
	public List<Movies> displayEditedMovies (User u) throws Exception{
		List<Movies> l = new ArrayList<>();
		String sql = "select m.movie_id,title from movies m left outer join reviews r on m.movie_id = r.movie_id and r.user_id =? where r.review is not null";
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, u.getId());
			try (ResultSet rs = stmt.executeQuery()){
				while (rs.next()) {
					Movies m = new Movies(rs.getInt("movie_id"), rs.getString("title"), null);
					l.add(m);
				}
			}
		}
		return l;
	}
	
	
	
	public int createReview (Reviews rv) throws Exception{
		int count = 0;
		String sql = "insert into reviews values(default,?,?,?,?,now())";
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, rv.getMovie_id());
			stmt.setString(2, rv.getReview());
			stmt.setInt(3, rv.getRating());
			stmt.setInt(4,rv.getUser_id());
			count = stmt.executeUpdate();
		}
		
		return count;
	}
	
	
	
	public int editReview (Reviews rv, User u) throws Exception {
		int count = 0;
		String sql = "update reviews set review =?, rating =? where user_id =? and movie_id =?";
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(4, rv.getMovie_id());
			stmt.setString(1, rv.getReview());
			stmt.setInt(2, rv.getRating());
			stmt.setInt(3,rv.getUser_id());
			count = stmt.executeUpdate();
		}
		return count;
	}
	
	
	public int deleteReview (int id) throws Exception {
		int count = 0;
		String sql = "delete from reviews where id = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, id);
			count = stmt.executeUpdate();
		}
		return count;
	}
	
	public List<Reviews> AllReview (User u) throws Exception{
		List<Reviews> l = new ArrayList<>();
		String sql = "select * from reviews";
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			try (ResultSet rs = stmt.executeQuery()){
				while (rs.next()) {
					Reviews rm = new Reviews(rs.getInt("id"), rs.getInt("movie_id"), rs.getString("review"), rs.getInt("rating"), rs.getInt("user_id"), rs.getTimestamp("modified"));
					l.add(rm);
				}
			}
		}
		return l;
	}
	
	public Reviews findReview (int id) throws Exception{
		String sql = "select * from reviews where id = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery()){
				while (rs.next()) {
					Reviews r = new Reviews(rs.getInt("id"), rs.getInt("movie_id"), rs.getString("review"), rs.getInt("rating"), rs.getInt("user_id"), rs.getTimestamp("modified"));
					return r;
				}
			}
		}
		return null;
	}
	
	
	
	public List<Review_Movie> displayAllReviews  () throws Exception{
		List<Review_Movie> l = new ArrayList<>();
		String sql = "select r.id review_id,m.id movie_id,title,rating,modified,review,user_id from movies m,reviews r where m.id = r.movie_id";
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			try (ResultSet rs = stmt.executeQuery()){
				while (rs.next()) {
					Review_Movie rm = new Review_Movie(rs.getInt("review_id"),rs.getInt("movie_id"),rs.getString("review"),rs.getInt("rating"),rs.getTimestamp("modified"),rs.getString("title"),rs.getInt("user_id"));
					l.add(rm);
				}
			}
		}
		return l;
	}
	
	
	public List<Review_Movie> displayMyReviews  (User u) throws Exception{
		List<Review_Movie> l = new ArrayList<>();
		String sql = "select r.id review_id,m.id movie_id,title,rating,modified,review,user_id from movies m,reviews r where m.id = r.movie_id and r.user_id =?";
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, u.getId());
			try (ResultSet rs = stmt.executeQuery()){
				while (rs.next()) {
					Review_Movie rm = new Review_Movie(rs.getInt("review_id"),rs.getInt("movie_id"),rs.getString("review"),rs.getInt("rating"),rs.getTimestamp("modified"),rs.getString("title"),rs.getInt("user_id"));
					l.add(rm);
				}
			}
		}
		return l;
	}
	
	public List<Reviews> displayMyReviews2  (User u) throws Exception{
		List<Reviews> l = new ArrayList<>();
		String sql = "select review_id,rating,modified,review from movies m,reviews r where m.id = r.movie_id and r.user_id =?";
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, u.getId());
			try (ResultSet rs = stmt.executeQuery()){
				while (rs.next()) {
					Reviews rm = new Reviews(rs.getInt("review_id"), 0,rs.getString("review"), rs.getInt("rating"), 0,rs.getTimestamp("modified"));
					l.add(rm);
				}
			}
		}
		return l;
	}
	
	
	public List<User> displayUser (User u) throws Exception{
		List<User> l = new ArrayList<User>();
		String sql = "select id,first_name,last_name,email from users where id not in (?)";
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, u.getId());
			try (ResultSet rs = stmt.executeQuery()){
				while (rs.next()) {
					User us = new User(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), null, null, null);
					l.add(us);
				}
			}
		}
		return l;
	}
	
	public int shareReviews (int user_id,int review_id) throws Exception {
		int count = 0;
		String sql = "insert into shares values (?,?)";
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, user_id);
			stmt.setInt(2, review_id);
			count = stmt.executeUpdate();
		}
		return count;
	}
	
	public List<Review_Movie> displaySharedReviews (User u) throws Exception {
		List<Review_Movie> l = new ArrayList<>();
		String sql = "select r.id review_id,m.id movie_id,title,rating,modified,review,s.user_id from reviews r,shares s,movies m,users u where r.id = s.review_id and r.movie_id = m.id and u.id =?";
		try (PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, u.getId());
			try (ResultSet rs = stmt.executeQuery()){
				while (rs.next()) {
					Review_Movie rm = new Review_Movie(rs.getInt("review_id"),rs.getInt("movie_id"),rs.getString("review"),rs.getInt("rating"),rs.getTimestamp("modified"),rs.getString("title"),rs.getInt("user_id"));
					l.add(rm);
				}
			}
		}
		return l;
	}
}
