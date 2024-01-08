package com.sunbeam.beans;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class LoginBean {
	private String email;
	private String password;
	private User user;
	private String message;
	
	public LoginBean() {
		user = new User();
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



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public LoginBean(String email, String password, User user, String message) {
		this.email = email;
		this.password = password;
		this.user = user;
		this.message = message;
	}

	@Override
	public String toString() {
		return "LoginBean [email=" + email + ", password=" + password + ", user=" + user + ", message=" + message + "]";
	}

	public void auth () {
		try(UserDao ud = new UserDaoImpl()){
			System.out.println("password:" + this.password);
			User u1 = ud.findByEmail(email);
			System.out.println(u1.getPassword());
			System.out.println(password);
			if (u1 != null && u1.getPassword().equals(password)) {
				this.user = u1;
				System.out.println(user.toString());
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
