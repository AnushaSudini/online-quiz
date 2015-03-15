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

import edu.memphis.quizemon.model.Quizemon;
import edu.memphis.quizemon.model.QuizemonDao;
import edu.memphis.quizemon.model.QuizemonDaoJdbc;
import edu.memphis.quizemon.model.Trade;
import edu.memphis.quizemon.model.TradeBean;
import edu.memphis.quizemon.model.TradeInfo;
import edu.memphis.quizemon.model.TradeDaoJdbc;
import edu.memphis.quizemon.model.TradeDao;
import edu.memphis.quizemon.model.TradeInfoDao;
import edu.memphis.quizemon.model.TradeInfoDaoJdbc;
import edu.memphis.quizemon.model.UserQuizemonDao;
import edu.memphis.quizemon.model.UserQuizemonDaoJdbc;

@WebServlet("/SubmitOffer.do")
public class SubmitOfferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TradeDao tradeDao;

	public SubmitOfferServlet()
	{
		super();
		this.tradeDao = new TradeDaoJdbc();
	}
	public void setTradeDao(TradeDao tradeDao) {
		this.tradeDao = tradeDao;
	}

	public TradeDao getTradeDao() {
		return tradeDao;
	}
	
	
       protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getRemoteUser();
		String quizemon = request.getParameter("quizemon");
		String reason = request.getParameter("Reason");
		System.out.println("Reasons: "+reason);
		System.out.println(quizemon);
		UserQuizemonDaoJdbc us = new UserQuizemonDaoJdbc();  
		us.deleteUserQuizemon(name, quizemon);
		TradeDaoJdbc tradeDao = new TradeDaoJdbc();
		TradeInfoDaoJdbc tradeInfoDao = new TradeInfoDaoJdbc();
		Trade tradeID = null;
		String[] ids = request.getParameterValues("quizemon");
		if (ids.length >0) {
			for (String id : ids) {
				System.out.println("Hellooooooo"+id);
				tradeID= tradeDao.createTrade(name);
				tradeInfoDao.createTradeInfo(((Trade) tradeID).getID(), id,reason);
				}
			}
		
		List<TradeInfo> tradeInformation =  tradeInfoDao.selectTradeInfo();
		List<String> userNameList = new ArrayList<String>();
		List<Quizemon> qList = tradeInfoDao.selectTradeInfoWithId(tradeID.getID());
		List<TradeBean> bean = tradeDao.selectTradeWithUser(name);
		ArrayList<String> reasons=tradeInfoDao.selectReasonsWithId(name);
		
		for(TradeBean tr : bean)
		{
			Trade ID = tradeDao.selectTradewithID(tr.getID());
			
			userNameList.add(ID.getUser());
		  qList.addAll(tr.getQuizemon());
		  
			
		}
		if(bean.size()>0)
		{
		
			request.setAttribute("tradeInformation", tradeInformation);
			request.setAttribute("list", userNameList);
			request.setAttribute("tr", bean);
			request.setAttribute("qList",qList);
			request.setAttribute("reasons",reasons);
		}
		
		String VIEW_PATH = "/WEB-INF/trade/offers.jsp";
		RequestDispatcher view = request.getRequestDispatcher(VIEW_PATH);
		view.forward(request, response);
		}

}

