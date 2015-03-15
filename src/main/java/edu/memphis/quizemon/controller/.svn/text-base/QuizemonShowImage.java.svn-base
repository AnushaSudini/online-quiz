package edu.memphis.quizemon.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.memphis.quizemon.model.QuizemonDaoJdbc;

@WebServlet("/QuizemonDisplayImage.do")
@ServletSecurity(value=@HttpConstraint(rolesAllowed = {"trainer","master"}))
public class QuizemonShowImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletOutputStream outputStream = response.getOutputStream();
		String imageId=request.getParameter("imgid");
		QuizemonDaoJdbc quizemonDaoJdbc=new QuizemonDaoJdbc();
		if(request.getParameter("imgid")==null) {
		} else {
			outputStream=response.getOutputStream();			
			response.setHeader("Cache-Control", "max-age=86400, private, must-revalidate"); // Cache for 1 day
			response.setContentType("image/jpg");
			try {
				byte[] b=quizemonDaoJdbc.getImage(imageId);
				
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			try {
				outputStream.write(quizemonDaoJdbc.getImage(imageId));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		outputStream.flush();
		outputStream.close();
	}

}
