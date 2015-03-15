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
import edu.memphis.quizemon.model.UserQuizemon;
import edu.memphis.quizemon.model.UserQuizemonDao;
import edu.memphis.quizemon.model.UserQuizemonDaoJdbc;

@WebServlet("/quizemons/showQuizemons.do")
public class QuizemonShowServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username =  request.getUserPrincipal().getName();
		UserQuizemonDao dao = new UserQuizemonDaoJdbc();
		List<Quizemon> userQuizemons = dao.selectUserQuizemonWithUserName(username);
		if (userQuizemons.isEmpty())
		{
			String viewPath = "/WEB-INF/quizemons/userQuizemonEmpty.jsp";
			RequestDispatcher view = request.getRequestDispatcher(viewPath);
			view.forward(request, response);
		}
		else {
			request.setAttribute("user_quizemons", userQuizemons);
			String viewPath = "/WEB-INF/quizemons/showQuizemons.jsp";
			RequestDispatcher view = request.getRequestDispatcher(viewPath);
			view.forward(request, response);
		}
	}
}
