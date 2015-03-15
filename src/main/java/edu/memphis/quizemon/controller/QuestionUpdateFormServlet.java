package edu.memphis.quizemon.controller;

import java.io.IOException;






import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import edu.memphis.quizemon.model.Answer;
import edu.memphis.quizemon.model.Category;
import edu.memphis.quizemon.model.Question;
import edu.memphis.quizemon.model.QuestionDao;
import edu.memphis.quizemon.model.QuestionDaoJdbc;
import edu.memphis.quizemon.model.QuizCategoryDao;
import edu.memphis.quizemon.model.QuizCategoryDaoJdbc;

/**
 * Servlet implementation class CategoriesUpdateFormServlet
 */
@WebServlet("/quiz/updateQuestion.do")
public class QuestionUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int questionId;

	QuestionDao questionDao;
	
	public QuestionUpdateFormServlet(){
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
	
		String qId = request.getParameter("questionId");

		if (qId != null && qId != "") {
			questionId=Integer.parseInt(qId);
			QuestionDao dao = new QuestionDaoJdbc();

			Question question = dao.selectQuestionWithID(questionId);
			Answer answers=dao.selectAnswerWithQuestionId(questionId);
			if (question != null && answers!=null) {
				request.setAttribute("question", question);
				request.setAttribute("answers", answers);
				String viewPath = "/WEB-INF/quiz/updateQuestion.jsp";
				RequestDispatcher view = request.getRequestDispatcher(viewPath);
				view.forward(request, response);
			} else {
				JOptionPane.showMessageDialog(null,"The selected question was already deleted!","",JOptionPane.INFORMATION_MESSAGE);
				String viewPath = "/quiz/index.do";
				response.sendRedirect(viewPath);
			}
		} else {
			JOptionPane.showMessageDialog(null,"The selected question does not exist!","",JOptionPane.INFORMATION_MESSAGE);
			String viewPath = "/quiz/index.do";
			response.sendRedirect(viewPath);
		}

	}

}
