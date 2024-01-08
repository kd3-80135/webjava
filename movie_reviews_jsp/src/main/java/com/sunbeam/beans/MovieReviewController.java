package com.sunbeam.beans;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ctl")
public class MovieReviewController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page = req.getParameter("page");
		String jspPath = "";
		
		if(page.equals("index"))
			jspPath = "/index.jsp";
		else if(page.equals("auth"))
			jspPath = "/auth.jsp";
		else if(page.equals("reviews"))
			jspPath = "/reviews.jsp";
		else if(page.equals("register"))
			jspPath = "/register.jsp";
		else if(page.equals("signup"))
			jspPath = "/signup.jsp";
		else if(page.equals("deletereview"))
			jspPath = "/deletereview.jsp";
		else if(page.equals("logout"))
			jspPath = "/logout.jsp";
		else if(page.equals("editreview"))
			jspPath = "/editreview.jsp";
		else if(page.equals("sharereview"))
			jspPath = "/sharereview.jsp";
		else if(page.equals("announcement"))
			jspPath = "/announcement.jsp";
		else if(page.equals("announce"))
			jspPath = "/announce.jsp";
		else 
			jspPath = "/notfound.jsp";
		
		ServletContext ctx = req.getServletContext();
		RequestDispatcher rd = ctx.getRequestDispatcher(jspPath);
		rd.forward(req, resp);		
	}
}
