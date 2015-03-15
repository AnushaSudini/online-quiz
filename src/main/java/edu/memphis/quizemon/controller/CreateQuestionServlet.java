package edu.memphis.quizemon.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.memphis.quizemon.model.Answer;
import edu.memphis.quizemon.model.Category;
import edu.memphis.quizemon.model.Question;
import edu.memphis.quizemon.model.QuestionDao;
import edu.memphis.quizemon.model.QuestionDaoJdbc;
import edu.memphis.quizemon.model.QuizCategoryDao;
import edu.memphis.quizemon.model.QuizCategoryDaoJdbc;

/**
 * Servlet implementation class CreateQuestionServlet
 */
@WebServlet("/quiz/formQuestion.do")
public class CreateQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option1=null;
		String option2=null;
		String option3=null;
		String option4=null;
		String answer=null;
		String type=null;
		int easyQue=0;
		int mediumQue=0;
		int hardQue=0;
		String categoryName=null;
		QuestionDao dao = new QuestionDaoJdbc();
		QuizCategoryDao categoryDao=new QuizCategoryDaoJdbc();
		Answer answers = new Answer(0,null,null,null,null,null,null);
		Question questionObject=new Question(0,null,null,null,null);
		type=request.getParameter("type");
		categoryName=request.getParameter("name");
		questionObject.setQuestionCategory(categoryName);
		questionObject.setQuestionContent(request.getParameter("question"));
		questionObject.setQuestionType(type);
		questionObject.setQuestionDifficulty(request.getParameter("difficulty"));
		easyQue=dao.countEasy(categoryName);
		mediumQue=dao.countMedium(categoryName);
		hardQue=dao.countHard(categoryName);
		if(easyQue>=10 && mediumQue>=10 && hardQue>=10)
		{
			boolean flag=categoryDao.activateCategory(categoryName);
			
				
			
		}
		Category category=new Category(categoryName, null, null);
		
		answers.setQuestionType(type);
		if(request.getParameter("type").equals("Multiple Choice Questions")||request.getParameter("type").equals("Spelling")||request.getParameter("type").equals("Fill in the blank"))
		{
			
			option1=request.getParameter("option1");
			option2=request.getParameter("option2");
			option3=request.getParameter("option3");
			option4=request.getParameter("option4");
			answer=request.getParameter("answer");
			answers.setoption1(option1);
			answers.setoption2(option2);
			answers.setoption3(option3);
			answers.setoption4(option4);
			answers.setanswer(answer);
			
		}
		else if(request.getParameter("type").equals("True or False"))
		{
			answer=request.getParameter("bool");
			answers.setanswer(answer);
			
		}
		if(request.getParameter("type").equals("Multiple Choice Questions")||request.getParameter("type").equals("Spelling"))
		{
			if((answer.equals(option1)||answer.equals(option2)||answer.equals(option3)||answer.equals(option4))==true)
			{
				int questionID=dao.createQuestionId();
				questionObject.setQuestionId(questionID);
				answers.setQuestionId(questionID);
				dao.createQuestion(questionObject,answers);
				String redirectUrl = this.getServletContext().getContextPath() + "/quiz/index.do";
				response.sendRedirect(redirectUrl);
			}
		}
		else if(request.getParameter("type").equals("Fill in the blank"))
		{
			int questionID=dao.createQuestionId();
			questionObject.setQuestionId(questionID);
			answers.setQuestionId(questionID);
			dao.createQuestion(questionObject,answers);
			String redirectUrl = this.getServletContext().getContextPath() + "/quiz/index.do";
			response.sendRedirect(redirectUrl);
		}
		
		else if(request.getParameter("type").equals("True or False"))
		{
			
				int questionID=dao.createQuestionId();
				questionObject.setQuestionId(questionID);
				answers.setQuestionId(questionID);
				dao.createQuestion(questionObject,answers);
				
				String redirectUrl = this.getServletContext().getContextPath() + "/quiz/index.do";
				response.sendRedirect(redirectUrl);
			
		}
		
	}


}
