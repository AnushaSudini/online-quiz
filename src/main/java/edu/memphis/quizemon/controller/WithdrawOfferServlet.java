package edu.memphis.quizemon.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.memphis.quizemon.model.Trade;
import edu.memphis.quizemon.model.TradeDao;
import edu.memphis.quizemon.model.TradeDaoJdbc;
import edu.memphis.quizemon.model.TradeInfoDaoJdbc;
import edu.memphis.quizemon.model.UserQuizemon;
import edu.memphis.quizemon.model.UserQuizemonDaoJdbc;

@WebServlet("/WithdrawOfferServlet.do")
public class WithdrawOfferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   TradeDaoJdbc tradeDao = new TradeDaoJdbc();
		TradeInfoDaoJdbc tradeinfo= new TradeInfoDaoJdbc();
		UserQuizemonDaoJdbc uqDao = new UserQuizemonDaoJdbc();
		String user_name = request.getRemoteUser();
		String id = request.getParameter("id");
		String quizemon = request.getParameter("qid");
		uqDao.createUserQuizemon(user_name, quizemon);
		tradeDao.deleteTradewithID(new Integer(id).intValue());
		tradeinfo.deleteTradewithID(new Integer(id).intValue());
	 /*  HttpSession session = request.getSession();
		ServletContext context = session.getServletContext();
		response.sendRedirect( "http://localhost:8096/quizemon/ViewTradeFormServlet.do");*/
		String viewPath = "/WEB-INF/trade/view.jsp";
		RequestDispatcher view = request.getRequestDispatcher(viewPath);
		view.forward(request, response);
		
		
   }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TradeDaoJdbc tradeDao = new TradeDaoJdbc();
		TradeInfoDaoJdbc tradeinfo= new TradeInfoDaoJdbc();
		UserQuizemonDaoJdbc uqDao = new UserQuizemonDaoJdbc();
		String user_name = request.getRemoteUser();
		String quizemon = request.getParameter("quizemon");
		String id = request.getParameter("id");
		HttpSession session = request.getSession();
		ServletContext context = session.getServletContext();
		uqDao.createUserQuizemon(user_name, quizemon);
		tradeDao.deleteTradewithID(new Integer(id).intValue());
		tradeinfo.deleteTradewithID(new Integer(id).intValue());
		System.out.println("The trade has been deleted"+new Integer(id).intValue());
	//doGet(request, response);
	String viewPath = "/WEB-INF/trade/view.jsp";
	RequestDispatcher view = request.getRequestDispatcher(viewPath);
	view.forward(request, response);
		
	}
	
	}

