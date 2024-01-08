package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoInterface;
import com.sunbeam.pojo.User;


@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		try(UserDaoInterface ud = new UserDao()){
			User u = ud.findByEmail(email);
			if (u != null && u.getPassword().equals(password)) {
				HttpSession session = req.getSession();
				session.setAttribute("currentUser", u);
				resp.sendRedirect("reviews");
			}
			else {
				PrintWriter out =  resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Login Failed</title>");
				out.println("</head>");
				out.println("<tbody>");
				out.println("<h2>Invalid user_id or password</h2>");
				out.println("<a href ='index.html'> Login Again</a>&nbsp;&nbsp;&nbsp;&nbsp;");
				out.println("<a href ='register.html'>Sign Up</a>");
				out.println("</tbody>");	
			}	
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
	
}
