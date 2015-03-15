package edu.memphis.quizemon.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.memphis.quizemon.model.Quizemon;
import edu.memphis.quizemon.model.QuizemonDao;
import edu.memphis.quizemon.model.QuizemonDaoJdbc;
import edu.memphis.quizemon.model.UserCoinDao;
import edu.memphis.quizemon.model.UserCoinDaoJdbc;
import edu.memphis.quizemon.model.UserQuizemon;
import edu.memphis.quizemon.model.UserQuizemonDao;
import edu.memphis.quizemon.model.UserQuizemonDaoJdbc;

@WebServlet("/quizmons/delete.do")
@ServletSecurity(value=@HttpConstraint(rolesAllowed = {"master"}))
public class QuizmonDeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] names = request.getParameterValues("id");
		QuizemonDao dao = new QuizemonDaoJdbc();
		UserQuizemonDao userquizmondao = new UserQuizemonDaoJdbc();
		UserCoinDao usercoindao = new UserCoinDaoJdbc();

		if (names != null) {
			for (String name : names) {
				Quizemon quizemon = dao.selectQuizemonWithName(name);
				int price = quizemon.getPrice();
				List<UserQuizemon> userquizemons = userquizmondao.selectUserQuizemonWithQuizmonName(name);
				for (UserQuizemon userquizemon : userquizemons) {
					String username = userquizemon.getUser();
					int newcoins = usercoindao.selectUserCoinWithName(username) + price;
					userquizmondao.deleteUserQuizemon(username, name);
					usercoindao.updateUserCoin(username, newcoins);
				}
				dao.deleteQuizemon(name);
			}
		}

		String redirectUrl = this.getServletContext().getContextPath() + "/quizemons/index.do";
		response.sendRedirect(redirectUrl);
	}
}
