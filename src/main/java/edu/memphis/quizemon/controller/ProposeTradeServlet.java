package edu.memphis.quizemon.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.memphis.quizemon.model.Propose;
import edu.memphis.quizemon.model.ProposeDaoJdbc;
import edu.memphis.quizemon.model.ProposeDao;
import edu.memphis.quizemon.model.ProposeInfo;
import edu.memphis.quizemon.model.ProposeInfoDaoJdbc;
import edu.memphis.quizemon.model.Quizemon;
import edu.memphis.quizemon.model.TradeDaoJdbc;
import edu.memphis.quizemon.model.TradeInfo;
import edu.memphis.quizemon.model.TradeInfoDaoJdbc;
import edu.memphis.quizemon.model.UserQuizemon;
import edu.memphis.quizemon.model.UserQuizemonDaoJdbc;

@WebServlet("/ProposeTradeServlet.do")
public class ProposeTradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static int proposeId;   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getRemoteUser();
		String id= request.getParameter("id");
		System.out.println("PROPOSE TRADE SERVLET id is"+id);
		UserQuizemonDaoJdbc quize = new UserQuizemonDaoJdbc();
		TradeDaoJdbc tr = new TradeDaoJdbc();
		List<Quizemon> quizemonList = quize.selectUserQuizemonWithUserName(user);
		if(!(quizemonList.isEmpty()))
		{
		request.setAttribute("quizemonList", quizemonList);
		request.setAttribute("id", id);
		String VIEW_PATH = "/WEB-INF/trade/quizemonPropose.jsp";
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

