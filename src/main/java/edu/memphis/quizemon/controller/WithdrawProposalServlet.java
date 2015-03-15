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

import edu.memphis.quizemon.model.ProposeDaoJdbc;
import edu.memphis.quizemon.model.ProposeInfoDaoJdbc;
import edu.memphis.quizemon.model.TradeDaoJdbc;
import edu.memphis.quizemon.model.TradeInfoDaoJdbc;
import edu.memphis.quizemon.model.UserQuizemonDaoJdbc;

@WebServlet("/WithdrawProposalServlet.do")
public class WithdrawProposalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ProposeDaoJdbc proposeDao = new ProposeDaoJdbc();
			ProposeInfoDaoJdbc proposeinfo= new ProposeInfoDaoJdbc();
			UserQuizemonDaoJdbc uqDao = new UserQuizemonDaoJdbc();
			String user_name = request.getRemoteUser();
			String id = request.getParameter("id");
			String quizemon = request.getParameter("qid");
			uqDao.createUserQuizemon(user_name, quizemon);
			proposeDao.deleteProposeWithProposeID(new Integer(id).intValue());
			proposeinfo.deleteProposeInfoWithProposeID(new Integer(id).intValue());
		 /*  HttpSession session = request.getSession();
			ServletContext context = session.getServletContext();
			response.sendRedirect( "http://localhost:8096/quizemon/ViewProposeTradeServlet.do");*/
			String viewPath = "/WEB-INF/trade/view.jsp";
			RequestDispatcher view = request.getRequestDispatcher(viewPath);
			view.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ProposeDaoJdbc proposeDao = new ProposeDaoJdbc();
			ProposeInfoDaoJdbc proposeinfo= new ProposeInfoDaoJdbc();
			UserQuizemonDaoJdbc uqDao = new UserQuizemonDaoJdbc();
			String user_name = request.getRemoteUser();
			String id = request.getParameter("id");
			String quizemon = request.getParameter("qid");
			uqDao.createUserQuizemon(user_name, quizemon);
			proposeDao.deleteProposeWithProposeID(new Integer(id).intValue());
			proposeinfo.deleteProposeInfoWithProposeID(new Integer(id).intValue());
			System.out.println("The trade has been deleted"+new Integer(id).intValue());
		  /* HttpSession session = request.getSession();
			ServletContext context = session.getServletContext();
			response.sendRedirect( "http://localhost:8096/quizemon/ViewProposeTradeServlet.do");*/
			String viewPath = "/WEB-INF/trade/view.jsp";
			RequestDispatcher view = request.getRequestDispatcher(viewPath);
			view.forward(request, response);
	}

}
