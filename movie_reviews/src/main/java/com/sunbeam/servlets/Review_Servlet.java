package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoInterface;
import com.sunbeam.pojo.Review_Movie;
import com.sunbeam.pojo.User;


@WebServlet("/reviews")
public class Review_Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User curUser = (User)session.getAttribute("currentUser");
		System.out.println(curUser.toString());
		String Type = req.getParameter("type");
		System.out.println(Type);
		
		try(UserDaoInterface ud = new UserDao()){
			int i = 1;
			List<Review_Movie> list;
			if (Type == null || Type.equals("all")) {
				list = ud.displayAllReviews();
			}
			else if (Type.equals("my")) {
				list = ud.displayMyReviews(curUser);
			}
			else {
				list = ud.displaySharedReviews(curUser);
			}
			
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Reviews</title>");
			out.println("</head>");
			out.println("<body>");
			out.printf("<h2>Hello %s  %s</h2><br><br>", curUser.getFirstName(),curUser.getLastName());
			out.printf("<a href='reviews?type=my' >My Reviews</a> |    ");
			out.printf("<a href='reviews?type=all' >All Reviews</a> |     ");
			out.printf("<a href='reviews?type=shared' >Shared Reviews</a> |  ");
			out.println("<table border=1>");
			out.println("<thead>");
			out.println("<th>review_id</th>");
			out.println("<th>movie_id</th>");
			out.println("<th>Rating</th>");
			out.println("<th>Review</th>");
			out.printf("<th>TimeStamp</th>");
			out.println("<th>Action</th>");
			out.println("<thead>");
			out.println("<tbody>");
			
			
			for (Review_Movie rm:list) {
				out.println("<tr>");
				out.printf("<td>%s</td>", rm.getMovie_id());
				out.printf("<td>%s</td>", rm.getReview_id());
				out.printf("<td>%s</td>", rm.getTitle());
				out.printf("<td>%s</td>", rm.getRating());
				out.printf("<td>%s</td>", rm.getReview());
				out.printf("<td>%s</td>", rm.getModified());
				if (curUser.getId() == rm.getUser_id()) {
					out.printf("<td><a href='reviewedit?id=%s&movie=%s'><img src='edit.png' alt='edit' width='24' height='24'></img></a><a href = 'reviewdelete?id=%s'><img src='delete.png' alt='delete' width='24' height='24'></img></a><a href='reviewshare?id=%s'><img src='share.png' alt='share' width='24' height='24'></img></a></td>",rm.getReview_id(),rm.getTitle(),rm.getReview_id(),rm.getReview_id());
				}
				out.println("</tr>");
				i++;
			}
			out.println("</tbody>");
			out.println("<table>");
			out.println("<a href = 'addreview'>Add Review</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='logout'>Sign Out</a>");
			out.println("</body>");
			out.println("</html>");
		}catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
