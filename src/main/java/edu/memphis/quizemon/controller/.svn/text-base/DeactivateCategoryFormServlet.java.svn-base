package edu.memphis.quizemon.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import edu.memphis.quizemon.model.QuizCategoryDao;
import edu.memphis.quizemon.model.QuizCategoryDaoJdbc;


/**
 * Servlet implementation class DeactivateCategoryFormServlet
 */
@WebServlet("/quiz/deactivateCategory.do")
public class DeactivateCategoryFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private int questionId;

	QuizCategoryDao categoryDao;

	public DeactivateCategoryFormServlet(){
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

		String name = request.getParameter("categoryName");
		

		if (name != null && !name.isEmpty()) {
			
			QuizCategoryDao dao = new QuizCategoryDaoJdbc();

			boolean flag=dao.deactivateCategory(name);
			if (flag==true) {
				
				String viewPath = "/quiz/index.do";
				RequestDispatcher view = request.getRequestDispatcher(viewPath);
				view.forward(request, response);
			} else {
				JOptionPane.showMessageDialog(null,"The selected category was already deactivated!","",JOptionPane.INFORMATION_MESSAGE);
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
