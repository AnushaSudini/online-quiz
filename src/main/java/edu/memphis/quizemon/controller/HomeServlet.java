package edu.memphis.quizemon.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home.do")
@ServletSecurity(value=@HttpConstraint(rolesAllowed = {"trainer", "master"}))
public class HomeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String TRAINER_ROLE = "trainer";
		String MASTER_ROLE = "master";
		String PATH_ROOT = request.getServletContext().getContextPath();
		String TRAINER_PATH = PATH_ROOT + "/quizemonTrainerHome.do";
		String MASTER_PATH = PATH_ROOT + "/quizMasterHome.do";
		if (request.isUserInRole(TRAINER_ROLE)) {
			response.sendRedirect(TRAINER_PATH);
		} else if (request.isUserInRole(MASTER_ROLE)) {
			response.sendRedirect(MASTER_PATH);
		} else {
			// This should never happen.
		}
	}

}
