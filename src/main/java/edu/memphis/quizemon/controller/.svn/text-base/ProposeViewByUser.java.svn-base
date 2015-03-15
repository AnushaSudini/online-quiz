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
import edu.memphis.quizemon.model.ProposeDao;
import edu.memphis.quizemon.model.ProposeDaoJdbc;


@WebServlet("/trade/showProposeByUser.do")
public class ProposeViewByUser extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getUserPrincipal().getName();
		ProposeDao dao = new ProposeDaoJdbc();
		List<ProposeBean> propose = dao.selectProposeWithUserName(username);
		if(propose.isEmpty())
		{
			String viewPath = "/WEB-INF/trade/userProposeEmpty.jsp";
			RequestDispatcher view = request.getRequestDispatcher(viewPath);
			view.forward(request, response);
		}
		else
		{
			request.setAttribute("propose", propose);		
			String viewPath = "/WEB-INF/trade/showProposeByUser.jsp";
			RequestDispatcher view = request.getRequestDispatcher(viewPath);
			view.forward(request, response);
		}
	}
}
