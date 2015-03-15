package edu.memphis.quizemon.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.memphis.quizemon.model.Category;
import edu.memphis.quizemon.model.QuizCategoryDao;
import edu.memphis.quizemon.model.QuizCategoryDaoJdbc;

/**
 * Servlet implementation class CategoriesShowServlet
 */
@WebServlet("/quiz/show.do")
public class CategoriesShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		QuizCategoryDao categoryDao = new QuizCategoryDaoJdbc();
		Category category = categoryDao.selectCategoryWithName(name);
		request.setAttribute("category", category );
		String viewPath = "/WEB-INF/quiz/showCategory.jsp";
		RequestDispatcher view = request.getRequestDispatcher(viewPath);
		view.forward(request, response);

	}

}



