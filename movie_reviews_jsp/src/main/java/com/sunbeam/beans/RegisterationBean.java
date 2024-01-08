package com.sunbeam.beans;


import java.util.Date;

import org.apache.jasper.JasperException;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoInterface;
import com.sunbeam.pojo.User;
import com.sunbeam.util.DateUtill;

public class RegisterationBean {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String mobile;
	private String birth;
	private User user;
	private boolean status; 
	
	public RegisterationBean() {
	}
	
	public RegisterationBean(String firstName, String lastName, String email, String password, String mobile,
			String birth, User user, boolean status) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.birth = birth;
		this.user = user;
		this.status = status;
	}

	@Override
	public String toString() {
		return "RegisterationBean [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", mobile=" + mobile + ", birth=" + birth + ", user=" + user + ", status="
				+ status + "]";
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
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



	public String getMobile() {
		return mobile;
	}



	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	public String getBirth() {
		return birth;
	}



	public void setBirth(String birth) {
		this.birth = birth;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public boolean isStatus() {
		return status;
	}



	public void setStatus(boolean status) {
		this.status = status;
	}



	public boolean addUser() throws Exception{
		System.out.println("1");
		try(UserDaoInterface ud = new UserDao()){
			Date uDate = DateUtill.parse(birth);
			User u = new User(0, firstName, lastName, email, password, uDate, mobile);
			int count = ud.signUp(u);
			System.out.println("3");
			if (count == 1) {
				this.user = u;
				this.status = true;
			}
			return status;
		}catch (Exception e) {
			e.printStackTrace();
			throw new JasperException(e);
		}
	}
}
