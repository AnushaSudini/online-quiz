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
import edu.memphis.quizemon.model.ProposeInfo;
import edu.memphis.quizemon.model.ProposeInfoDao;
import edu.memphis.quizemon.model.ProposeDaoJdbc;
import edu.memphis.quizemon.model.ProposeInfoDaoJdbc;
import edu.memphis.quizemon.model.Quizemon;
import edu.memphis.quizemon.model.Trade;
import edu.memphis.quizemon.model.TradeBean;
import edu.memphis.quizemon.model.TradeInfo;
import edu.memphis.quizemon.model.UserQuizemonDaoJdbc;

@WebServlet("/SubmitProposal.do")
public class SubmitProposalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getRemoteUser();
		String tradeid = request.getParameter("tradeid");
		System.out.println("The trade id is"+tradeid);
		String quizemon = request.getParameter("quizemon");
		String reason = request.getParameter("Reason");
		System.out.println("The reason is"+reason);
		System.out.println("quizemon");
		UserQuizemonDaoJdbc us = new UserQuizemonDaoJdbc();
		us.deleteUserQuizemon(user, quizemon);
		ProposeDaoJdbc proposeDao = new ProposeDaoJdbc();
		ProposeInfoDaoJdbc proposeInfoDao = new ProposeInfoDaoJdbc();
		Propose proposeID = null;
		String[] ids = request.getParameterValues("quizemon");
		if (ids.length >0) {
			for (String id : ids) {
				proposeID= proposeDao.createPropose(user, new Integer(tradeid).intValue() );
				System.out.println(((Propose) proposeID).getProposeID());
				proposeDao.createProposeInfo(((Propose) proposeID).getProposeID(), id, reason);  //((Propose) proposeID).getProposeID()
				}
			}
		List<ProposeInfo> proposeInformation =  proposeInfoDao.selectProposeInfo();
			List<String> userNameList = new ArrayList<String>();
			List<Quizemon> qList = proposeInfoDao.selectProposeInfoWithId(proposeID.getProposeID());
			List<ProposeBean> bean = proposeDao.selectProposeWithUserName(user);
			List<String> reasons=proposeInfoDao.selectReasonsWithProposeId(user);
			List<Propose> ID = null;
			
			for(ProposeBean pr: bean)
			{
				ID = proposeDao.selectProposeWithTradeID(pr.getTradeID());
				int trid = pr.getTradeID();
			    qList.addAll(pr.getProposeQuizemon());
			}
		 if(bean.size()>0)
		 {
			 request.setAttribute("proposeInformation", proposeInformation);
				request.setAttribute("bean", bean);
				request.setAttribute("qlist", qList);
				request.setAttribute("reasons", reasons);
			}
		String VIEW_PATH = "/WEB-INF/trade/proposeIndex.jsp";
		RequestDispatcher view = request.getRequestDispatcher(VIEW_PATH);
		view.forward(request, response);
	}

}
