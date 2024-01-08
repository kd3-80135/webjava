package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.exceptions.MySQLQueryInterruptedException;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoInterface;
import com.sunbeam.pojo.User;
import com.sunbeam.util.DateUtill;

@WebServlet("/register")
public class SignUpServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String date = req.getParameter("birth");
		Date uDate = DateUtill.parse(date);
		String password = req.getParameter("password");
		User u = new User(0, fname, lname, email, password, uDate, mobile);
		try(UserDaoInterface ud = new UserDao()){
			int count = ud.signUp(u);
			if (count == 1) {
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Login</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h1>Please Login Again now.</h1><br>");
				out.println("<form method='get' action = 'index.html'><input type = 'submit' value = 'Login'></form>");
				out.println("</body>");
				out.println("</html>");
			}
			else {
				System.out.println("MySQL Query Exceprion. Check UserDao.");
			}			
		}catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
	
	
	
}
