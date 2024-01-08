package com.sunbeam.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoInterface;
import com.sunbeam.pojo.User;

@WebServlet("/reviewdelete")
public class DeleteReviewServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User curUser = (User)session.getAttribute("currentUser");
		
		try(UserDaoInterface ud = new UserDao()){
			int id = Integer.parseInt(req.getParameter("id"));
			int count = ud.deleteReview(id);
			if (count == 1) {
				RequestDispatcher rd = req.getRequestDispatcher("reviews");
				rd.forward(req, resp);
				System.out.println("Review Deletion Succeefull");
			}
			else {
				RequestDispatcher rd = req.getRequestDispatcher("reviews");
				rd.forward(req, resp);
				System.out.println("Review Deletion Unsucessfull");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}
	
	
	
}
