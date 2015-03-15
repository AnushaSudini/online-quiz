package edu.memphis.quizemon.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTMLDocument.Iterator;

import edu.memphis.quizemon.model.Quizemon;
import edu.memphis.quizemon.model.Trade;
import edu.memphis.quizemon.model.TradeDao;
import edu.memphis.quizemon.model.TradeDaoJdbc;
import edu.memphis.quizemon.model.TradeInfo;
import edu.memphis.quizemon.model.TradeInfoDaoJdbc;
import edu.memphis.quizemon.model.UserQuizemon;
import edu.memphis.quizemon.model.UserQuizemonDao;
import edu.memphis.quizemon.model.UserQuizemonDaoJdbc;

@WebServlet("/OfferTrade.do")


public class OfferTradeFormServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	
	UserQuizemonDao userQuizemonDao;

	public OfferTradeFormServlet(){
		super();
		this.userQuizemonDao = new UserQuizemonDaoJdbc();
	}
	public void setUserQuizemonDao(UserQuizemonDao userQuizemonDao) {
		this.userQuizemonDao = userQuizemonDao;
	}

	public UserQuizemonDao getUserQuizemonDao() {
		return userQuizemonDao;
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_name = request.getRemoteUser();
		UserQuizemonDaoJdbc quize = new UserQuizemonDaoJdbc();
		List<Quizemon> quizemonList = quize.selectUserQuizemonWithUserName(user_name);
		if(!(quizemonList.isEmpty()))
		{
		request.setAttribute("quizemonList", quizemonList);
		String VIEW_PATH = "/WEB-INF/trade/quizemonOffer.jsp";
		RequestDispatcher view = request.getRequestDispatcher(VIEW_PATH);
		view.forward(request, response);
		}
		else
		{
			String VIEW_PATH = "/WEB-INF/trade/noQuizemons.jsp";
			RequestDispatcher view = request.getRequestDispatcher(VIEW_PATH);
			view.forward(request, response);
		}
	}


}
