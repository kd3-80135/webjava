package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.VoterDao;
import com.sunbeam.daos.VoterDaoImpl;
import com.sunbeam.pojo.Voter;

@WebServlet("/vote")
public class VoteServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Voter voter = (Voter)session.getAttribute("currentVoter");
		if (voter.getStatus() != 0) {
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Voting Done</title>");
			out.println("</head>");
			out.println("<body>");
			out.printf("Hello, %s %s <hr/>\r \n",voter.getFirstName(),voter.getLastName());
			out.println("<h5>You have already voted.</h5>");
			out.println("<a href='logout'>Sign Out</a>");
			out.println("</body>");
			out.println("</html>");
		}
		else {
			int c_id = Integer.parseInt(req.getParameter("candidate"));
			try(CandidateDao cd = new CandidateDaoImpl()){
				int count = cd.incrementVote(c_id);
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Voting Done</title>");
				out.println("</head>");
				out.println("<body>");
				out.printf("Hello , %s %s <hr>'\r\n",voter.getFirstName(),voter.getLastName());
				
				if (count == 1) {
					try(VoterDao vd = new VoterDaoImpl()){
						voter.setStatus(1);
						int cnt = vd.updateStatus(voter.getId(), true);
						if (cnt == 1) {
							out.println("<h3>Your vote has been registered successfully.</h3>");
						}
					}
				}
				if (count == 0) {
					out.println("<h3>Some error has occured. Try again.</h3>");
				}
				out.println("<a href='logout'>Sign Out </a>");
				out.println("</body>");
				out.println("</html>");
				
			}catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}
	}
}
