package edu.memphis.quizemon.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.memphis.quizemon.model.ProposeDao;
import edu.memphis.quizemon.model.ProposeDaoJdbc;

@WebServlet("/trade/declineTrade.do")
public class ProposeDeclineServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] ids = request.getParameterValues("id");
		ProposeDao dao = new ProposeDaoJdbc();

		if (ids != null) {
			for (String id : ids) {
				int propose_id = new Integer(id).intValue();
				dao.deleteProposeWithProposeID(propose_id);
			}
		}

		//String redirectUrl = this.getServletContext().getContextPath() + "/trade/declinePropose.do";
		String viewPath = "/WEB-INF/trade/proposeDeclineSuccess.jsp";
		RequestDispatcher view = request.getRequestDispatcher(viewPath);
		view.forward(request, response);
	}

}
