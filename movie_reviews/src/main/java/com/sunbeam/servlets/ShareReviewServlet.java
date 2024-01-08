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

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoInterface;
import com.sunbeam.pojo.Reviews;
import com.sunbeam.pojo.User;

@WebServlet("/reviewshare")
public class ShareReviewServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User curUser = (User)session.getAttribute("currentUser");
		
		int review_id = Integer.parseInt(req.getParameter("id"));
		try(UserDaoInterface ud = new UserDao()){
			List<User> list = ud.displayUser(curUser);
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Share Review</title>");
			out.println("<body>");
			out.printf("<form method ='post' action = 'reviewshare?review_id=%s'>",review_id);
			out.printf("Review_Id : <input value ='%s' name='review_id' readonly/><br><br>",review_id);
			out.println("<select name = 'id'>");
			for (User u : list) {
				out.printf("<option name = 'id' value ='%s'>%s %s </option>",u.getId(),u.getFirstName(),u.getLastName());
			}
			out.println("</select>");
			out.println("<input type = 'submit' value = 'Share'/><br><br>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User curUser = (User)session.getAttribute("currentUser");
		
		int review_id = Integer.parseInt(req.getParameter("review_id"));
		int user_id = Integer.parseInt(req.getParameter("id"));
		System.out.println(review_id + " " + " " + user_id);
		try(UserDaoInterface ud = new UserDao()){
			int count = ud.shareReviews(review_id,user_id);
			if (count == 1) {
				resp.sendRedirect("reviews");
				System.out.println("Sharing Successs.");
			}
			else {
				resp.sendRedirect("reviews");
				System.out.println("Sharing Failed.");
			}
		}catch (Exception e){
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		
	}
}
