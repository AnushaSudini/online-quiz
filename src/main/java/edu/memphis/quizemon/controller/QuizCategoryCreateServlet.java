package edu.memphis.quizemon.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.memphis.quizemon.model.QuizCategoryDao;
import edu.memphis.quizemon.model.QuizCategoryDaoJdbc;

/**
 * Servlet implementation class QuizCategoryCreateServlet
 */
@WebServlet("/quiz/createCategory.do")
public class QuizCategoryCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String categoryName = request.getParameter("name");
			String description = request.getParameter("description");
			QuizCategoryDao dao = new QuizCategoryDaoJdbc();
			dao.createCategory(categoryName, description);

			String redirectUrl = this.getServletContext().getContextPath() + "/quiz/index.do";
			response.sendRedirect(redirectUrl);

	}

}
