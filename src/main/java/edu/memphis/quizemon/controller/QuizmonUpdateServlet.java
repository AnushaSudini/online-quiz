package edu.memphis.quizemon.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.FileCleanerCleanup;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.apache.commons.io.FileCleaningTracker;

import edu.memphis.quizemon.model.ImageUtil;
import edu.memphis.quizemon.model.Quizemon;
import edu.memphis.quizemon.model.QuizemonDao;
import edu.memphis.quizemon.model.QuizemonDaoJdbc;

@WebServlet("/quizemons/update.do")
@ServletSecurity(value=@HttpConstraint(rolesAllowed = {"master"}))
public class QuizmonUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String originname = request.getParameter("originname");
		InputStream originimage = request.getInputStream();
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
		int i =0;
		for(FileItem item : items){
   	  	 System.out.println(i++);
			          if(!item.isFormField()){
			        	  	 System.out.println(item.getName());
			        	  	 System.out.println("ai niuniu");
			        	  	 if(item.getName() != null && item.getName()!= ""){
			                     is=item.getInputStream();
			              	  	 System.out.println(is);
			        	  	 }
			          }
			          else
			        	  System.out.println(item.getName());
				          if(item.getFieldName().compareTo("originname")==0)
				        	  originname=item.getString();
			  					System.out.println(originname);
			  			  if(item.getFieldName().compareTo("originimage")==0)
			  				  originimage=item.getInputStream();
			  			  		System.out.println(originimage);

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
			dao.updateQuizemon(originname, name, new Integer(price).intValue(), rareness, 
					new Integer(weight).intValue(), specialpower, is );
		}
		/*QuizemonDao dao2 = new QuizemonDaoJdbc();
		Quizemon quizemon = dao2.selectQuizemonWithName(name);
		request.setAttribute("quizemon", quizemon);
		
		String viewPath = "/WEB-INF/quizemons/quizmonshow.jsp";
		RequestDispatcher view = request.getRequestDispatcher(viewPath);
		view.forward(request, response);*/
		String redirectUrl = this.getServletContext().getContextPath() + "/quizemons/index1.do";
		response.sendRedirect(redirectUrl);
	}

}