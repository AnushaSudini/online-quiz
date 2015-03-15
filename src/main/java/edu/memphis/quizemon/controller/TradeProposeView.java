package edu.memphis.quizemon.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/trade/showTrade&Propose.do")
public class TradeProposeView extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPath = "/WEB-INF/trade/showTrade&Propose.jsp";
		RequestDispatcher view = request.getRequestDispatcher(viewPath);
		view.forward(request, response);
	}
}
