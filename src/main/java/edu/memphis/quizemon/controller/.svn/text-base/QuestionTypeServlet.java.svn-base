package edu.memphis.quizemon.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.memphis.quizemon.model.Answer;
import edu.memphis.quizemon.model.Question;
import edu.memphis.quizemon.model.QuestionDao;
import edu.memphis.quizemon.model.QuestionDaoJdbc;
import edu.memphis.quizemon.model.QuizCategoryDao;
import edu.memphis.quizemon.model.QuizCategoryDaoJdbc;

/**
 * Servlet implementation class CreateQuestionServlet
 */
@WebServlet("/quiz/typeOfQuestion.do")
public class QuestionTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QuestionDao dao = new QuestionDaoJdbc();
		Question questionObject=new Question(0,null,null,null,null);
		String category=request.getParameter("name");
		String questionType=request.getParameter("type");
		questionObject.setQuestionCategory(category);
		questionObject.setQuestionType(questionType);
		
		request.setAttribute("question", questionObject);
		
		String viewpath = "/WEB-INF/quiz/manageQuestion.jsp";
		RequestDispatcher view = request.getRequestDispatcher(viewpath);
		view.forward(request, response);
		
	}


}
