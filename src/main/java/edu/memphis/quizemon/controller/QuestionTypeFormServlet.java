package edu.memphis.quizemon.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.memphis.quizemon.model.Category;
import edu.memphis.quizemon.model.QuestionDao;
import edu.memphis.quizemon.model.QuestionDaoJdbc;
import edu.memphis.quizemon.model.QuizCategoryDao;
import edu.memphis.quizemon.model.QuizCategoryDaoJdbc;

/**
 * Servlet implementation class CreateQuestionFormServlet
 */
@WebServlet("/quiz/questionType.do")
public class QuestionTypeFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	QuestionDao questionDao;

	public QuestionTypeFormServlet(){
		super();
		this.questionDao = new QuestionDaoJdbc();
	}

	public void setQuestionDao(QuestionDao questionDao){
		this.questionDao = questionDao;
	}

	public QuestionDao getQuestionDao(){
		return questionDao;
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categoryName=request.getParameter("categoryName");
		if (categoryName != null && categoryName != "") {
			QuizCategoryDao dao = new QuizCategoryDaoJdbc();
			Category category = dao.selectCategoryWithName(categoryName);
			request.setAttribute("category", category);
			String viewPath = "/WEB-INF/quiz/questionType.jsp";
			RequestDispatcher view = request.getRequestDispatcher(viewPath);
			view.forward(request, response);

		}


	}
}