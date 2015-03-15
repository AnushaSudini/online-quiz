package edu.memphis.quizemon.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.memphis.quizemon.model.ProposeDao;
import edu.memphis.quizemon.model.ProposeDaoJdbc;
import edu.memphis.quizemon.model.Quizemon;

@WebServlet("/trade/acceptTrade.do")
public class ProposeAcceptServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int propose_id = new Integer(request.getParameter("id")).intValue();
		
		List <Quizemon> result = new ArrayList<Quizemon>();
		ProposeDao dao = new ProposeDaoJdbc();
		result = dao.acceptProposeWithProposeID(propose_id);
		
		request.setAttribute("newQuizemon", result);
		
		String viewPath = "/WEB-INF/trade/viewTradeGet.jsp";
		RequestDispatcher view = request.getRequestDispatcher(viewPath);
		view.forward(request, response);
	}

}
