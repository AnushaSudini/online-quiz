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
import edu.memphis.quizemon.model.TradeBean;
import edu.memphis.quizemon.model.TradeDaoJdbc;
import edu.memphis.quizemon.model.TradeDao;
import edu.memphis.quizemon.model.TradeDaoJdbc;


@WebServlet("/trade/showTradeByUser.do")
public class TradeViewByUser extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getUserPrincipal().getName();
		TradeDao dao = new TradeDaoJdbc();
		List<TradeBean> trade = dao.selectTradeWithUser(username);
		if(trade.isEmpty())
		{
			String viewPath = "/WEB-INF/trade/userTradeEmpty.jsp";
			RequestDispatcher view = request.getRequestDispatcher(viewPath);
			view.forward(request, response);

		}
		else{
			request.setAttribute("trade", trade);		
			String viewPath = "/WEB-INF/trade/showTradeByUser.jsp";
			RequestDispatcher view = request.getRequestDispatcher(viewPath);
			view.forward(request, response);
		}
	}
}
