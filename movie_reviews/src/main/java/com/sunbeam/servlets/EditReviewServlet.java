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
import com.sunbeam.pojo.Reviews;
import com.sunbeam.pojo.User;


@WebServlet("/reviewedit")
public class EditReviewServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User curUser = (User)session.getAttribute("currentUser");
		
		int id = Integer.parseInt(req.getParameter("id"));
		String movie = req.getParameter("movie");
		System.out.println(movie);
		try(UserDaoInterface ud = new UserDao()){
			Reviews r = ud.findReview(id);
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Edit</title>");
			out.println("<body>");
			out.printf("<form method ='post' action = 'reviewedit?movie_id=%s'>",r.getMovie_id());
			out.printf("Review_Id : <input value ='%s' name='review_id' readonly/><br><br>",r.getId());
			out.printf("Movie : <input value = '%s' readonly/><br><br>",movie);
			out.printf("Rating : <input type = 'number' min = 1 max = 5 name = 'rating'><br><br>");
			out.println("Review :<textarea cols='40' rows='3' name='review'></textarea><br><br>");
			out.println("<input type = 'submit' value = 'Update'/><br><br>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new ServletException();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User curUser = (User)session.getAttribute("currentUser");
		
		String review = (String)req.getParameter("review");
		int rating = Integer.parseInt(req.getParameter("rating"));
		int user_id = curUser.getId();
		int review_id = Integer.parseInt(req.getParameter("review_id"));
		int movie_id = Integer.parseInt(req.getParameter("movie_id"));
		
		Reviews rev = new Reviews(review_id, movie_id, review, rating, user_id, null);
		try(UserDaoInterface ud = new UserDao()){
			int count = ud.editReview(rev, curUser);
			if (count == 1) {
				System.out.println("success");
				resp.sendRedirect("reviews");
			}
			else {
				System.out.println("failure to update.");
				resp.sendRedirect("reviews");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

	
	
}
