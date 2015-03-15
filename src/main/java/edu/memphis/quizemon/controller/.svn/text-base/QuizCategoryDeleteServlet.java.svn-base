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
 * Servlet implementation class QuizCategoryDeleteServlet
 */
@WebServlet("/quiz/deleteCategory.do")
public class QuizCategoryDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] names = request.getParameterValues("name");
		QuizCategoryDao categoryDao = new QuizCategoryDaoJdbc();

		if (names != null) {
			for (String name : names) {
				categoryDao.deleteCategory(name);
			}
		}

		String redirectUrl = this.getServletContext().getContextPath() + "/quiz/index.do";
		response.sendRedirect(redirectUrl);
	}


}


