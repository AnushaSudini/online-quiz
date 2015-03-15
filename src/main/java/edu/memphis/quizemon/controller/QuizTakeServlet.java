package edu.memphis.quizemon.controller;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/quiz/take.do")
public class QuizTakeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page;
		QuizMultipleChoiceQuestion quiz;
		String [] answers;
		String [] questionId = new String[10];

		QuestionDao dao = new QuestionDaoJdbc();
//		if(request.getParameter("page") == null)
//		{
			String topic = request.getParameter("name");
			String difflevel = request.getParameter("difficulty");
			int easyNum = 0 ;
			int mediumNum = 0 ; 
			int hardNum = 0 ;
	
			switch (difflevel) {
				case "easy":
					easyNum = 8;
					mediumNum = 2;
					hardNum = 0;
					break;
				case "medium":
					easyNum = 6;
					mediumNum = 2;
					hardNum = 2;
					break;
				case "hard":
					easyNum = 0;
					mediumNum = 2;
					hardNum = 8;
					break;
			}
			page = 1;
			List<Question> Questions= dao.selectTenQuestons(easyNum, mediumNum, hardNum, topic);
			int i =0;
			for (Question q: Questions)
			{
				questionId[i] = Integer.toString(q.getQuestionId());
				i++;
			}
			
	        HttpSession session=request.getSession();  
	        session.setAttribute("page", page);
	        session.setAttribute("questionId", questionId);
	        
	        System.out.println("********************my questionIds are: ");
	        for(i=0;i<10;i++)
	        {
	        	 System.out.println(questionId[i]);
	        }
	        System.out.println("********************************************** ");

			Question question = dao.selectQuestionWithID(Integer.parseInt(questionId[page-1]));
			Answer answer = dao.selectAnswerWithQuestionId(Integer.parseInt(questionId[page-1]));
			quiz = new QuizMultipleChoiceQuestion(question, answer);
			
			answers = new String[10];
			for(int j=0;j<10;j++)
			{
				answers[j] = "";
			}
			session.setAttribute("answers",answers);
//		}
		
//		else
/*		{
			page = Integer.parseInt(request.getParameter("page"));
			System.out.println(page);
			
	        HttpSession session=request.getSession();  
	        questionId = (String[]) session.getAttribute("questionId");
	        
	        System.out.println(questionId[2]);
			Question question = dao.selectQuestionWithID(Integer.parseInt(questionId[page-1]));
			Answer ans = dao.selectAnswerWithQuestionId(Integer.parseInt(questionId[page-1]));
			quiz = new QuizMultipleChoiceQuestion(question, ans);
			
			answers = (String[]) session.getAttribute("answers");
			String answer;
			System.out.println("answer1"+session.getAttribute("answer"));
			if(request.getParameter("answer") == null)
			{
				System.out.println("I cannot get the answer!!!!");
				answer = "";
			}
			else
			{
				answer = request.getParameter("answer");
			}
			
			answers[page-1] = answer;
			session.setAttribute("answers", answers);
		}*/
		
		request.setAttribute("page", page);
		request.setAttribute("quiz", quiz);
		
		String viewPath = "/WEB-INF/quiz/takeQuiz.jsp";
		RequestDispatcher view = request.getRequestDispatcher(viewPath);
		view.forward(request, response);
	}
}
