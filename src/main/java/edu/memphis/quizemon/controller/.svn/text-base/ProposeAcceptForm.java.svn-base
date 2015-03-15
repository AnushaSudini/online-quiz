package edu.memphis.quizemon.controller;

import java.io.IOException;
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



@WebServlet("/trade/acceptTradeForm.do")
public class ProposeAcceptForm extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int trade_id = new Integer(request.getParameter("trade_id")).intValue();
		ProposeDao dao = new ProposeDaoJdbc();
		List<ProposeBean> propose = dao.selectProposeWithTradeId(trade_id);
		
		request.setAttribute("propose", propose);
		
		String viewPath = "/WEB-INF/trade/acceptTradeForm.jsp";
		RequestDispatcher view = request.getRequestDispatcher(viewPath);
		view.forward(request, response);
	}
}
