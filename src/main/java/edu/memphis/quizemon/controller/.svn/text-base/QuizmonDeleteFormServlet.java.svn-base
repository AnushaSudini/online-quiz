package edu.memphis.quizemon.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.memphis.quizemon.model.Quizemon;
import edu.memphis.quizemon.model.QuizemonDao;
import edu.memphis.quizemon.model.QuizemonDaoJdbc;

@WebServlet("/quizemons/deleteForm.do")
@ServletSecurity(value=@HttpConstraint(rolesAllowed = {"master"}))
public class QuizmonDeleteFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QuizemonDao dao = new QuizemonDaoJdbc();
		List<Quizemon> quizemons = dao.selectAllQuizemon();
		request.setAttribute("quizemons", quizemons);
		String viewPath = "/WEB-INF/quizemons/deleteForm.jsp";
		RequestDispatcher view = request.getRequestDispatcher(viewPath);
		view.forward(request, response);
	}
}
