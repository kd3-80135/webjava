package com.sunbeam.beans;

import org.apache.jasper.JasperException;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoInterface;
import com.sunbeam.pojo.User;

public class LoginBean {
	private String email;
	private String password;
	private User user;
	
	public LoginBean() {
	}
	
	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public LoginBean(String email, String password, User user) {
		super();
		this.email = email;
		this.password = password;
		this.user = user;
	}


	@Override
	public String toString() {
		return "LoginBean [email=" + email + ", password=" + password + ", user=" + user + "]";
	}


	public void authenticate() throws Exception{
		try(UserDaoInterface ud = new UserDao()){
			User u = ud.findByEmail(email);
			if (u != null && u.getPassword().equals(password)) {
				this.user = u;
			}
			return;
		}catch (Exception e) {
			e.printStackTrace();
			throw new JasperException(e);
		}
	}
	
	
	
	
	
}
