package edu.memphis.quizemon.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import edu.memphis.quizemon.model.Answer;
import edu.memphis.quizemon.model.Question;
import edu.memphis.quizemon.model.QuestionDao;
import edu.memphis.quizemon.model.QuestionDaoJdbc;
import edu.memphis.quizemon.model.QuizCategoryDao;
import edu.memphis.quizemon.model.QuizCategoryDaoJdbc;


/**
 * Servlet implementation class QuizCategoryUpdateServlet
 */
@WebServlet("/quiz/editQuestion.do")
public class QuestionUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	QuestionDao questionDao;
	
	public QuestionUpdateServlet(){
		super();
		this.questionDao = new QuestionDaoJdbc();
	}
	
	public void setQuestion(QuestionDao questionDao){
		this.questionDao = questionDao;
	}
	
	public QuestionDao getQuestion(){
		return questionDao;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();
		String qID=request.getParameter("qID");
		int questionId= Integer.parseInt(qID);
		
		String categoryName = request.getParameter("category");
		
		String questionContent=request.getParameter("content");
		
		String difficulty=request.getParameter("difficulty");
		
		String type=request.getParameter("type");
		
		QuestionDao dao = new QuestionDaoJdbc();
		Question questionObject=new Question(questionId,categoryName,questionContent,difficulty,type);
		Answer answers = new Answer(questionId,null,null,null,null,null,type);
		String option1=null;
		String option2=null;
		String option3=null;
		String option4=null;
		
		String answer=null;
		if(request.getParameter("type").equals("Multiple Choice Questions")||request.getParameter("type").equals("Spelling"))
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
		else if(request.getParameter("type").equals("Fill in the blank"))
		{
			answer=request.getParameter("answer");
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
				questionObject.setQuestionId(questionId);
				answers.setQuestionId(questionId);
				
				dao.updateQuestion(questionObject,answers);
				
				String redirectUrl = this.getServletContext().getContextPath() + "/quiz/viewQuestionsByCategory.do?categoryName="+categoryName;
				response.sendRedirect(redirectUrl);
			}
		}
		else if(request.getParameter("type").equals("Fill in the blank"))
		{
			
			questionObject.setQuestionId(questionId);
			answers.setQuestionId(questionId);
			
			dao.updateQuestion(questionObject,answers);
			String redirectUrl = this.getServletContext().getContextPath() + "/quiz/viewQuestionsByCategory.do?categoryName="+categoryName;
			response.sendRedirect(redirectUrl);
		}
		
		else if(request.getParameter("type").equals("True or False"))
		{
			
				
				questionObject.setQuestionId(questionId);
				answers.setQuestionId(questionId);
				
				dao.updateQuestion(questionObject,answers);
				
				String redirectUrl = this.getServletContext().getContextPath() + "/quiz/viewQuestionsByCategory.do?categoryName="+categoryName;
				response.sendRedirect(redirectUrl);
			
		}		
		/*if (qID != null && qID != "") {
			
			dao.updateQuestion(questionId,categoryName,questionContent,difficulty,type);
	
			String redirectUrl = application.getContextPath() + "/quiz/show.do?name=" + categoryName;
			response.sendRedirect(redirectUrl);
		}*/ else {
			JOptionPane.showMessageDialog(null,"The selected category is not exist in the database!","",JOptionPane.INFORMATION_MESSAGE);
			String viewPath = "/quiz/index.do";
			response.sendRedirect(viewPath);
		}
	}
	
}
