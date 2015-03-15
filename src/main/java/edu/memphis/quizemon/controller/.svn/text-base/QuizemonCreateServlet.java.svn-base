package edu.memphis.quizemon.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

import edu.memphis.quizemon.model.Quizemon;
import edu.memphis.quizemon.model.QuizemonDao;
import edu.memphis.quizemon.model.QuizemonDaoJdbc;

@WebServlet("/quizemons/create.do")
@ServletSecurity(value=@HttpConstraint(rolesAllowed = {"master"}))
public class QuizemonCreateServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String rareness = request.getParameter("rareness");
		String weight = request.getParameter("weight");
		String specialpower = request.getParameter("specialpower");
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		java.util.List<FileItem> items=null;
		try {
			items = upload.parseRequest(new ServletRequestContext(request));
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		InputStream is=null;
		for(FileItem item : items){
			          if(!item.isFormField()){
		                     is=item.getInputStream();}
			          else
			        	
			          if(item.getFieldName().compareTo("name")==0)
		        	      name=item.getString();
			          if(item.getFieldName().compareTo("price")==0)
			        	  price=item.getString();
			          if(item.getFieldName().compareTo("rareness")==0)
			        	  rareness=item.getString();
			          if(item.getFieldName().compareTo("weight")==0)
			        	  weight=item.getString();
			          if(item.getFieldName().compareTo("specialpower")==0)
			        	  specialpower=item.getString();
		}
		if(name != "" && name != null){
			QuizemonDao dao = new QuizemonDaoJdbc();
			Quizemon newquizemon = dao.createQuizemon(name, new Integer(price).intValue(), rareness, 
					new Integer(weight).intValue(), specialpower, is );
		}
		
		String redirectUrl = this.getServletContext().getContextPath() + "/quizemons/index.do";
		response.sendRedirect(redirectUrl);
	}
}
