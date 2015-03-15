package edu.memphis.quizemon.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.memphis.quizemon.model.UserCoinDao;
import edu.memphis.quizemon.model.UserCoinDaoJdbc;

@WebServlet("/quiz/submit.do")
public class QuizSubmitServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String answers1 = request.getParameter("answer");
		int grade=0;
		HttpSession session=request.getSession();  
        String[] answers = (String[]) session.getAttribute("answers");
        int corranswernum = 0;
        
        if (answers1 != null){
	        String[] questioninfo = answers1.split(":"); 
	        String correctanswer = null;
        	String useranswer = null;
        	String difflevel = null;
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
			System.out.println("category"+category);
			answers[9] = category + ":" + useranswer + ":" + correctanswer + ":" + difflevel;
		}
        
        for(int i=0;i<10;i++){
			System.out.println("answers[i]"+answers[i]);
			if (answers[i] != null && answers[i] != ""){
		        String[] questioninfo = answers[i].split(":"); 
		        String correctanswer = null;
	        	String useranswer = null;
	        	String difflevel = null;
		        	correctanswer = questioninfo[2];
		        	useranswer = questioninfo[1];
		        	difflevel = questioninfo[3];
				if(correctanswer.equals(useranswer)){
					switch (difflevel){
						case "easy":
							grade = grade + 10;
							break;
						case "medium":
							grade = grade + 20;
							break;
						case "hard":
							grade = grade + 30;
							break;
					}
					corranswernum++;
					System.out.println("corranswernum"+corranswernum);
					System.out.println("grade"+grade);
				}
			}
		}
		
		UserCoinDao userdao = new UserCoinDaoJdbc();
		String username =  request.getUserPrincipal().getName();
		int usercoins = userdao.selectUserCoinWithName(username);
		int newcoins = usercoins+grade;
		int bonus = 0;
        if (corranswernum == 10) {
        	System.out.println("get bonus");
        	bonus = 20;
        	newcoins = newcoins + bonus;
        }
		userdao.updateUserCoin(username, newcoins);

		if(grade >= 60){
				request.setAttribute("grade", grade);
				request.setAttribute("bonus", bonus);				
				request.setAttribute("corranswernum", corranswernum);				
				String viewPath = "/WEB-INF/quiz/passQuiz.jsp";
				RequestDispatcher view = request.getRequestDispatcher(viewPath);
				view.forward(request, response);
			
		} else {
			String viewPath = "/WEB-INF/quiz/failQuiz.jsp";
			RequestDispatcher view = request.getRequestDispatcher(viewPath);
			view.forward(request, response);		
		}
		
		
	}
}
