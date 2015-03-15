package edu.memphis.quizemon.controller;

import java.awt.Window;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import javax.xml.ws.spi.http.HttpContext;

import edu.memphis.quizemon.model.UserCoin;
import edu.memphis.quizemon.model.UserCoinDao;
import edu.memphis.quizemon.model.UserCoinDaoJdbc;
import edu.memphis.quizemon.model.UserQuizemon;
import edu.memphis.quizemon.model.UserQuizemonDao;
import edu.memphis.quizemon.model.UserQuizemonDaoJdbc;

@WebServlet("/quiz/buyQuizemon.do")
public class QuizBuyQuizemonServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String[][] String = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Parameters = request.getParameter("quizemonInfo");
		System.out.print(Parameters);
	        String quizemon[] = Parameters.split(":"); 
			System.out.print(quizemon[0]);
			System.out.print(quizemon[1]);
			String quizemonName = quizemon[0];
			int quizemonPrice =new Integer(quizemon[1]).intValue();
			String username =  request.getUserPrincipal().getName();
			System.out.print(quizemonPrice);
			
			UserCoinDao userdao = new UserCoinDaoJdbc();
			int usercoins = userdao.selectUserCoinWithName(username);
			UserQuizemonDao userquizemondao = new UserQuizemonDaoJdbc();
			UserQuizemon userquizemon = userquizemondao.createUserQuizemon(username, quizemonName);
			int remaincoins = usercoins-quizemonPrice;
			System.out.print(remaincoins);
			userdao.updateUserCoin(username, remaincoins);
			System.out.print(usercoins);		
			String redirectUrl = this.getServletContext().getContextPath() + "/quizemons/showQuizemons.do";
			response.sendRedirect(redirectUrl);
	}
}
