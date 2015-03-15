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
import edu.memphis.quizemon.model.TradeDaoJdbc;
import edu.memphis.quizemon.model.TradeInfo;
import edu.memphis.quizemon.model.TradeInfoDao;
import edu.memphis.quizemon.model.TradeInfoDaoJdbc;

@WebServlet("/ProposeTradeFormServlet.do")
public class ProposeTradeFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	TradeInfoDao tradeInfoDao;

	public ProposeTradeFormServlet(){
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
		TradeDaoJdbc tradeDao = new TradeDaoJdbc();
		List<TradeInfo> tradeInfoList = tradeInfoDao.selectTradeInfo();
		List<Quizemon> qList = null;
		List<String> userNameList = new ArrayList<String>();
		Trade ID =null;
		String user_name = request.getRemoteUser();
		System.out.println("VIEW TRADE FORM SERVLET::: "+tradeInfoList);
		
		for(TradeInfo i: tradeInfoList)
		{
			qList =  tradeInfoDao.selectTradeInfoWithId(i.getID());
		     ID = tradeDao.selectTradewithID (i.getID());
		     userNameList.add(ID.getUser());
		}
		
		
		if(tradeInfoList !=null  && tradeInfoList.size()>0)
		{
		
			request.setAttribute("tradeInfoList", tradeInfoList);
			request.setAttribute("qList", qList);
			request.setAttribute("list", userNameList);
			request.setAttribute("user", user_name);
		}
		
		String viewPath = "/WEB-INF/trade/ProposeTradeForm.jsp";
		RequestDispatcher view = request.getRequestDispatcher(viewPath);
		view.forward(request, response);
		
	}

	

}
