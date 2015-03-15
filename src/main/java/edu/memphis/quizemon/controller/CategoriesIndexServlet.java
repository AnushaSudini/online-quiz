package edu.memphis.quizemon.controller;

import java.io.IOException;

import java.util.List;

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
 * Servlet implementation class CategoriesIndexServlet
 */
@WebServlet("/quiz/index.do")
public class CategoriesIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
		QuizCategoryDao categoryDao;
		
		public CategoriesIndexServlet() {
	        super();
	        this.categoryDao=new QuizCategoryDaoJdbc();
	    }
		
		public void setCategoryDao(QuizCategoryDao categoryDao)
		{
			this.categoryDao = categoryDao;
		}
		
		public QuizCategoryDao getCategoryDao() {
			return categoryDao;
		}

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			List<Category> categories = categoryDao.selectAllCategories();
			List<Category> activeCategories=categoryDao.selectActiveCategories();
			if(categories!=null&&!categories.isEmpty()||activeCategories!=null&&!activeCategories.isEmpty())
			{
			request.setAttribute("categories", categories);
			request.setAttribute("activeCategories", activeCategories);
			String viewPath = "/WEB-INF/quiz/CategoryIndex.jsp";
			RequestDispatcher view = request.getRequestDispatcher(viewPath);
			view.forward(request, response);
			}
			
		}

	}

	
	
	
    
