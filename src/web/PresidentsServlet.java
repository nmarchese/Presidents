package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.PresidentsDAO;
import data.PresidentsDAOImpl;

public class PresidentsServlet extends HttpServlet {
	PresidentsDAO presDAO;
	int term = 1;
	
	@Override
	public void init() throws ServletException {
		presDAO = new PresidentsDAOImpl(this.getServletContext());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.setAttribute("presidents", presDAO.getPresList());
		
		String nav = req.getParameter("nav");
		String goToTerm = req.getParameter("searchTerm");
		
		if (nav != null) {
			if (nav.equals("previous")) {
				req.setAttribute("president", presDAO.getPresident(--term));
				req.setAttribute("term", term);
			} else {
				req.setAttribute("president", presDAO.getPresident(++term));
				req.setAttribute("term", term);
			}
		} else if (goToTerm != null && goToTerm != "") {
			term = Integer.parseInt(goToTerm);
			req.setAttribute("president", presDAO.getPresident(term));
			req.setAttribute("term", term);
		} else if (nav == null || nav.equals("")) {
			req.setAttribute("president", presDAO.getPresident(term));
			req.setAttribute("term", term);
		}
		req.getRequestDispatcher("/president.jsp").forward(req, resp);
	}
}
