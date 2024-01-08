package com.sunbeam.beans;

import java.util.List;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoInterface;
import com.sunbeam.pojo.Reviews;

public class ReviewBean {
	List<Reviews> list;
	
	public ReviewBean() {
	}

	public List<Reviews> getList() {
		return list;
	}

	public void setList(List<Reviews> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "ReviewBean [list=" + list + "]";
	}

	public ReviewBean(List<Reviews> list) {
		this.list = list;
	}
	
	public void getReviews() {
		try(UserDaoInterface ud = new UserDao()){
			this.list = ud.displayAll();
			System.out.println(list.toString());
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
