package edu.memphis.quizemon.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.memphis.quizemon.model.Answer;
import edu.memphis.quizemon.model.Question;
import edu.memphis.quizemon.model.QuestionDao;
import edu.memphis.quizemon.model.QuestionDaoJdbc;
import edu.memphis.quizemon.model.QuizMultipleChoiceQuestion;

@WebServlet("/quiz/accept.do")
public class QuizAcceptAnswerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String answers = request.getParameter("answer");
			HttpSession session=request.getSession();  
			int count = (int) session.getAttribute("page");
			if (answers != null){
		        String[] questioninfo = answers.split(":"); 
		        String correctanswer = null;
	        	String useranswer = null;
	        	String difflevel = null;
	        	count = new Integer(questioninfo[0]).intValue();
	        	String category = questioninfo[1];
		        if (questioninfo[1].equals("Multiple Choice Questions")||questioninfo[1].equals("Spelling")||questioninfo[1].equals("True or False")) {
		        	correctanswer = questioninfo[3];
		        	useranswer = questioninfo[2];
		        	difflevel = questioninfo[4];
		        } else {
		        	correctanswer = questioninfo[2];
		        	useranswer = request.getParameter("answercontent");
		        	difflevel = questioninfo[3];
		        }
				System.out.println("correctanswer"+correctanswer);
				System.out.println("useranswer"+useranswer);
				System.out.println("difflevel"+difflevel);
				System.out.println("count"+count);
				System.out.println("category"+category);
		        String[] answers1 = (String[]) session.getAttribute("answers");
		        for(int i=0;i<10;i++)
		        {
		        	 System.out.println(answers1[i]);
		        }
				answers1[count-1] = category + ":" + useranswer + ":" + correctanswer + ":" + difflevel;
		        session.setAttribute("answers", answers1);
			} else {
				count = count - 1;
			}
			
	        String[] questionId = (String[]) session.getAttribute("questionId");
			QuestionDao dao = new QuestionDaoJdbc();
			Question question = dao.selectQuestionWithID(Integer.parseInt(questionId[count]));
			Answer answer = dao.selectAnswerWithQuestionId(Integer.parseInt(questionId[count]));
			QuizMultipleChoiceQuestion quiz = new QuizMultipleChoiceQuestion(question, answer);

			request.setAttribute("quiz", quiz);
			String viewPath = "/WEB-INF/quiz/takeQuiz.jsp";
			RequestDispatcher view = request.getRequestDispatcher(viewPath);
			view.forward(request, response);		
		}
		
}
