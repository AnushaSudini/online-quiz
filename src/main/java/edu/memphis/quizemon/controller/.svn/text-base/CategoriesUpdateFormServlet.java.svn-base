package edu.memphis.quizemon.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import edu.memphis.quizemon.model.Category;
import edu.memphis.quizemon.model.QuizCategoryDao;
import edu.memphis.quizemon.model.QuizCategoryDaoJdbc;

/**
 * Servlet implementation class CategoriesUpdateFormServlet
 */
@WebServlet("/quiz/updateForm.do")
public class CategoriesUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	QuizCategoryDao categoryDao;
	
	public CategoriesUpdateFormServlet(){
		super();
		this.categoryDao = new QuizCategoryDaoJdbc();
	}
	
	public void setCategoryDao(QuizCategoryDao categoryDao){
		this.categoryDao = categoryDao;
	}
	
	public QuizCategoryDao getCategoryDao(){
		return categoryDao;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name = request.getParameter("name");

		if (name != null && name != "") {
			QuizCategoryDao dao = new QuizCategoryDaoJdbc();

			Category category = dao.selectCategoryWithName(name);
			if (category != null) {
				request.setAttribute("category", category);
				String viewPath = "/WEB-INF/quiz/updateCategory.jsp";
				RequestDispatcher view = request.getRequestDispatcher(viewPath);
				view.forward(request, response);
			} else {
				JOptionPane.showMessageDialog(null,"The selected category was already deleted!","",JOptionPane.INFORMATION_MESSAGE);
				String viewPath = "/quiz/index.do";
				response.sendRedirect(viewPath);
			}
		} else {
			JOptionPane.showMessageDialog(null,"The selected category does not exist!","",JOptionPane.INFORMATION_MESSAGE);
			String viewPath = "/quiz/index.do";
			response.sendRedirect(viewPath);
		}

	}

}
