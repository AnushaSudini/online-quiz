package edu.memphis.quizemon.controller;

import java.io.IOException;
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
import edu.memphis.quizemon.model.UserCoinDao;
import edu.memphis.quizemon.model.UserCoinDaoJdbc;

@WebServlet("/store/enter.do")
public class StoreEnterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QuizemonDao dao = new QuizemonDaoJdbc();
		List<Quizemon> quizemons = dao.selectTenQuizemon();

		String username =  request.getUserPrincipal().getName();
		System.out.print(username);
		UserCoinDao userdao = new UserCoinDaoJdbc();
		int usercoins = userdao.selectUserCoinWithName(username);
		System.out.print(usercoins);		
		request.setAttribute("quizemons", quizemons);
		request.setAttribute("usercoins", usercoins);
		
		String viewPath = "/WEB-INF/quiz/enterStore.jsp";

		RequestDispatcher view = request.getRequestDispatcher(viewPath);
		view.forward(request, response);
	}
}
