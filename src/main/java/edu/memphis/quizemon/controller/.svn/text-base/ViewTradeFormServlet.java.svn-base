/*package edu.memphis.quizemon.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import edu.memphis.quizemon.model.Trade;
//import edu.memphis.quizemon.model.TradeDaoJdbc;
import edu.memphis.quizemon.model.TradeInfo;
import edu.memphis.quizemon.model.TradeInfoDao;
import edu.memphis.quizemon.model.TradeInfoDaoJdbc;
//import edu.memphis.quizemon.model.UserQuizemon;
//import edu.memphis.quizemon.model.UserQuizemonDaoJdbc;


@WebServlet("/ViewTradeFormServlet.do")
public class ViewTradeFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	TradeInfoDao tradeInfoDao;

	public ViewTradeFormServlet(){
		super();
		this.tradeInfoDao = new TradeInfoDaoJdbc();
	}
	
	public void setTradeInfoDao(TradeInfoDao tradeInfoDao) {
		this.tradeInfoDao = tradeInfoDao;
	}
	
	public TradeInfoDao getTradeInfoDao() {
		return tradeInfoDao;
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<TradeInfo> tradeInfoList = tradeInfoDao.selectTradeInfo();
		System.out.println("VIEW TRADE FORM SERVLET::: "+tradeInfoList);
		if(tradeInfoList !=null  && tradeInfoList.size()>0)
		{
		
			request.setAttribute("tradeInfoList", tradeInfoList);
		}
		
		String viewPath = "/WEB-INF/trade/viewTradeForm.jsp";
		RequestDispatcher view = request.getRequestDispatcher(viewPath);
		view.forward(request, response);
		
	}

	

}*/

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
import edu.memphis.quizemon.model.Trade;
import edu.memphis.quizemon.model.TradeBean;
import edu.memphis.quizemon.model.TradeDaoJdbc;
//import edu.memphis.quizemon.model.Trade;
//import edu.memphis.quizemon.model.TradeDaoJdbc;
import edu.memphis.quizemon.model.TradeInfo;
import edu.memphis.quizemon.model.TradeInfoDao;
import edu.memphis.quizemon.model.TradeInfoDaoJdbc;
//import edu.memphis.quizemon.model.UserQuizemon;
//import edu.memphis.quizemon.model.UserQuizemonDaoJdbc;
import edu.memphis.quizemon.model.UserQuizemonDao;
import edu.memphis.quizemon.model.UserQuizemonDaoJdbc;


@WebServlet("/ViewTradeFormServlet.do")
public class ViewTradeFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	TradeInfoDao tradeInfoDao;

	public ViewTradeFormServlet(){
		super();
		this.tradeInfoDao = new TradeInfoDaoJdbc();
	}
	
	public void setTradeInfoDao(TradeInfoDao tradeInfoDao) {
		this.tradeInfoDao = tradeInfoDao;
	}
	
	public TradeInfoDao getTradeInfoDao() {
		return tradeInfoDao;
	}
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		{
			TradeDaoJdbc tradeDao = new TradeDaoJdbc();
			List<TradeInfo> tradeInfoList = tradeInfoDao.selectTradeInfo();
			List<Quizemon> qList = null;
			List<String> userNameList = new ArrayList<String>();
			List<String> reasonList = new ArrayList<String>();
			Trade ID =null;
			System.out.println("VIEW TRADE FORM SERVLET::: "+tradeInfoList);
			for(TradeInfo i: tradeInfoList)
			{
				qList =  tradeInfoDao.selectTradeInfoWithId(i.getID());
			     ID = tradeDao.selectTradewithID (i.getID());
			     userNameList.add(ID.getUser());
			     reasonList.add(i.getReason());
			}
			
			
			if(tradeInfoList !=null  && tradeInfoList.size()>0)
			{
			
				request.setAttribute("tradeInfoList", tradeInfoList);
				request.setAttribute("qList", qList);
				request.setAttribute("list", userNameList);
				request.setAttribute("reasonList",reasonList);
			}
			
			String viewPath = "/WEB-INF/trade/viewTradeForm.jsp";
			RequestDispatcher view = request.getRequestDispatcher(viewPath);
			view.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TradeDaoJdbc tradeDao = new TradeDaoJdbc();
		List<TradeInfo> tradeInfoList = tradeInfoDao.selectTradeInfo();
		List<Quizemon> qList = null;
		List<String> userNameList = new ArrayList<String>();
		List<String> reasonList = new ArrayList<String>();
		Trade ID =null;
		System.out.println("VIEW TRADE FORM SERVLET::: "+tradeInfoList);
		for(TradeInfo i: tradeInfoList)
		{
			qList =  tradeInfoDao.selectTradeInfoWithId(i.getID());
		     ID = tradeDao.selectTradewithID (i.getID());
		     userNameList.add(ID.getUser());
		     reasonList.add(i.getReason());
		}
		
		
		if(tradeInfoList !=null  && tradeInfoList.size()>0)
		{
		
			request.setAttribute("tradeInfoList", tradeInfoList);
			request.setAttribute("qList", qList);
			request.setAttribute("list", userNameList);
			request.setAttribute("reasonList",reasonList);
		}
		
		String viewPath = "/WEB-INF/trade/viewTradeForm.jsp";
		RequestDispatcher view = request.getRequestDispatcher(viewPath);
		view.forward(request, response);
		
	}

	

}