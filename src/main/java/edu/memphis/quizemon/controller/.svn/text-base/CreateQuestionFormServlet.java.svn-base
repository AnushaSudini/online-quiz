package edu.memphis.quizemon.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.memphis.quizemon.model.Category;
import edu.memphis.quizemon.model.Question;
import edu.memphis.quizemon.model.QuestionDao;
import edu.memphis.quizemon.model.QuestionDaoJdbc;
import edu.memphis.quizemon.model.QuizCategoryDao;
import edu.memphis.quizemon.model.QuizCategoryDaoJdbc;

/**
 * Servlet implementation class CreateQuestionFormServlet
 */
@WebServlet("/quiz/createQuestion.do")
public class CreateQuestionFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	QuestionDao questionDao;

	public CreateQuestionFormServlet(){
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
		String questionType=request.getParameter("questionType");
		if (categoryName != null && categoryName != "" && questionType!="" && questionType!=null) {
			QuizCategoryDao dao = new QuizCategoryDaoJdbc();
			Question questionObject=new Question(0, categoryName, null, null, questionType);
			request.setAttribute("question", questionObject);
			String viewPath = "/WEB-INF/quiz/createQuestion.jsp";
			RequestDispatcher view = request.getRequestDispatcher(viewPath);
			view.forward(request, response);

		}


	}
}