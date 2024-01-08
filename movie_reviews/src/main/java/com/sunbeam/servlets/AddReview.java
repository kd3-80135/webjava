package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoInterface;
import com.sunbeam.pojo.Movies;
import com.sunbeam.pojo.Reviews;
import com.sunbeam.pojo.User;

@WebServlet("/addreview")
public class AddReview extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		String rev = req.getParameter("msg");
		int rating = Integer.parseInt(req.getParameter("rating"));
		int id = Integer.parseInt(req.getParameter("movies"));
		User curUser = (User)session.getAttribute("currentUser");
		int user_id = curUser.getId();
		
		try(UserDaoInterface ud = new UserDao()){
			Reviews rv = new Reviews(0, id, rev, rating, user_id, null);
			int count = ud.createReview(rv);
			if (count == 1) {
				RequestDispatcher rd = req.getRequestDispatcher("reviews");
				rd.forward(req, resp);
				System.out.println("Review Addition Succeefull");
			}
			else {
				RequestDispatcher rd = req.getRequestDispatcher("reviews");
				rd.forward(req, resp);
				System.err.println("Review Adding Failed");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User curUser = (User)session.getAttribute("currentUser");
		
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Add Reviews</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<br><br><form method='post' action='addreview'>");
			out.println("<select name='movies'>");
			try(UserDaoInterface ud = new UserDao()){
				List<Movies> list = ud.displayMovies();
			for (Movies l:list) {
				out.printf("<option  value=%d>%s </option>", l.getMovieId(),l.getTitle());
			}
			}
			catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
			out.println("</select>");
			out.printf("<h3>Rating : </h3><input type='number' min='1', max='5' name= 'rating'/><br><br><br>");
			out.printf("<h2>Review</h2>");
			out.printf("<textarea name='msg' rows='3' cols='40'></textarea><hr>");
			out.println("<input type='submit' value='Save'/>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");

		}
		
		
		
		
		
	
	
}
