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

import edu.memphis.quizemon.model.QuizCategoryDao;
import edu.memphis.quizemon.model.QuizCategoryDaoJdbc;


/**
 * Servlet implementation class QuizCategoryUpdateServlet
 */
@WebServlet("/quiz/updateCategory.do")
public class QuizCategoryUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	QuizCategoryDao categoryDao;
	
	public QuizCategoryUpdateServlet(){
		super();
		this.categoryDao = new QuizCategoryDaoJdbc();
	}
	
	public void setCategory(QuizCategoryDao categoryDao){
		this.categoryDao = categoryDao;
	}
	
	public QuizCategoryDao getCategory(){
		return categoryDao;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();
		String name= request.getParameter("name");
		String categoryName = request.getParameter("newName");
		String description = request.getParameter("info");
		
		if (categoryName != null && categoryName != "") {
			QuizCategoryDao dao = new QuizCategoryDaoJdbc();
			dao.updateCategory(name,categoryName, description);
	
			String redirectUrl = application.getContextPath() + "/quiz/show.do?name=" + categoryName;
			response.sendRedirect(redirectUrl);
		} else {
			JOptionPane.showMessageDialog(null,"The selected category is not exist in the database!","",JOptionPane.INFORMATION_MESSAGE);
			String viewPath = "/quiz/index.do";
			response.sendRedirect(viewPath);
		}
	}
	
}
