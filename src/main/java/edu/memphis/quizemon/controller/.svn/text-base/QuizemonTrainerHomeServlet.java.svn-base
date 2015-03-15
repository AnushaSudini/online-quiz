package edu.memphis.quizemon.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/quizemonTrainerHome.do")
@ServletSecurity(value=@HttpConstraint(rolesAllowed = {"trainer"}))
public class QuizemonTrainerHomeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String VIEW_PATH = "/WEB-INF/quizemonTrainerHome.jsp";
		RequestDispatcher view = request.getRequestDispatcher(VIEW_PATH);
		view.forward(request, response);
	}

}
