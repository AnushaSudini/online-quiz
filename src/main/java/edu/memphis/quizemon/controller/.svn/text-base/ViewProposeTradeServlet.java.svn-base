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

import edu.memphis.quizemon.model.Propose;
import edu.memphis.quizemon.model.ProposeBean;
import edu.memphis.quizemon.model.ProposeDaoJdbc;
import edu.memphis.quizemon.model.ProposeInfo;
import edu.memphis.quizemon.model.ProposeInfoDaoJdbc;
import edu.memphis.quizemon.model.Quizemon;
import edu.memphis.quizemon.model.Trade;
import edu.memphis.quizemon.model.TradeDaoJdbc;
import edu.memphis.quizemon.model.TradeInfo;
import edu.memphis.quizemon.model.TradeInfoDaoJdbc;

@WebServlet("/ViewProposeTradeServlet.do")
public class ViewProposeTradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProposeDaoJdbc proposeDao = new ProposeDaoJdbc();
		ProposeInfoDaoJdbc proposeInfoDao = new ProposeInfoDaoJdbc();
		List<ProposeInfo> proposeInfoList = proposeInfoDao.selectProposeInfo();
		List<Quizemon> qList = null;
		List<String> userNameList = new ArrayList<String>();
			List<String> reasonList = new ArrayList<String>();
		List<Integer> tradeIdList = new ArrayList<Integer>();
		Propose ID =null;
		
		for(ProposeInfo i: proposeInfoList)
		{
			qList =  proposeInfoDao.selectProposeInfoWithId(i.getID());
		     ID = proposeDao.selectProposeWithProposeID (i.getID());
		     userNameList.add(ID.getUser());
		      reasonList.add(i.getReason());
		   tradeIdList.add(ID.getTradeID());
		     
		}
		
		
		if(proposeInfoList.size()>0)
		{
		
			request.setAttribute("proposeInfoList", proposeInfoList);
			request.setAttribute("qList", qList);
			request.setAttribute("userList", userNameList);
			request.setAttribute("reasonList",reasonList);
			request.setAttribute("tradeIdList", tradeIdList);
			
		}
		
		String viewPath = "/WEB-INF/trade/viewProposeInfo.jsp";
		RequestDispatcher view = request.getRequestDispatcher(viewPath);
		view.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProposeDaoJdbc proposeDao = new ProposeDaoJdbc();
		ProposeInfoDaoJdbc proposeInfoDao = new ProposeInfoDaoJdbc();
		List<ProposeInfo> proposeInfoList = proposeInfoDao.selectProposeInfo();
		List<Quizemon> qList = null;
		List<String> userNameList = new ArrayList<String>();
			List<String> reasonList = new ArrayList<String>();
	    List<Integer> tradeIdList = new ArrayList<Integer>();
		Propose ID =null;
		System.out.println("VIEW TRADE FORM SERVLET::: ");
		
		for(ProposeInfo i: proposeInfoList)
		{
			qList =  proposeInfoDao.selectProposeInfoWithId(i.getID());
		     ID = proposeDao.selectProposeWithProposeID (i.getID());
		     userNameList.add(ID.getUser());
		      reasonList.add(i.getReason());
		   tradeIdList.add(ID.getTradeID());
		     
		}
		
		
		if(proposeInfoList.size()>0)
		{
		
			request.setAttribute("proposeInfoList", proposeInfoList);
			request.setAttribute("qList", qList);
			request.setAttribute("userList", userNameList);
			request.setAttribute("reasonList",reasonList);
		    request.setAttribute("tradeIdList", tradeIdList);
			
		}
		
		String viewPath = "/WEB-INF/trade/viewProposeInfo.jsp";
		RequestDispatcher view = request.getRequestDispatcher(viewPath);
		view.forward(request, response);
		
	}
	
	
	

}
