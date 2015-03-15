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

import edu.memphis.quizemon.model.ProposeBean;
import edu.memphis.quizemon.model.ProposeDao;
import edu.memphis.quizemon.model.ProposeDaoJdbc;
import edu.memphis.quizemon.model.Quizemon;
import edu.memphis.quizemon.model.QuizemonDao;
import edu.memphis.quizemon.model.QuizemonDaoJdbc;
import edu.memphis.quizemon.model.UserQuizemon;
import edu.memphis.quizemon.model.UserQuizemonDao;
import edu.memphis.quizemon.model.UserQuizemonDaoJdbc;

@WebServlet("/trade/viewPropose.do")
public class ProposeViewByTrade extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int trade_id =new Integer(request.getParameter("trade_id")).intValue();
		ProposeDao dao = new ProposeDaoJdbc();
		List<ProposeBean> propose = dao.selectProposeWithTradeId(trade_id);
		if(propose.isEmpty())
		{
			String viewPath = "/WEB-INF/trade/viewProposeEmpty.jsp";
			RequestDispatcher view = request.getRequestDispatcher(viewPath);
			view.forward(request, response);
		}
		else
		{
			request.setAttribute("propose", propose);
			request.setAttribute("trade_id", trade_id);
			
			String viewPath = "/WEB-INF/trade/viewPropose.jsp";
			RequestDispatcher view = request.getRequestDispatcher(viewPath);
			view.forward(request, response);
		}
	}
}
