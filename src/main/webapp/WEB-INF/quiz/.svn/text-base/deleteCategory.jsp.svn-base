<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List,edu.memphis.quizemon.model.Category"%>
<%
	List<Category> categories = (List<Category>) request.getAttribute("categories");
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Quiz | Delete Quiz Category Form </title>
<link href="../bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="../css/dashboard.css" rel="stylesheet">

</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand">Hello <%=request.getRemoteUser()%></a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a
						href="<%=request.getServletContext().getContextPath()%>/home.do">Home</a></li>
					<li><a
						href="<%=request.getServletContext().getContextPath()%>/logout.do">Log
							out</a></li>
				</ul>
			</div>
		</div>
	</div>


	
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
<fieldset>
<legend>Delete Categories</legend>

	<form action="<%=application.getContextPath()%>/quiz/deleteCategory.do"
		method="post">

	
		<table border="1" class="table">

			<tr>
				<th>&times;</th>
				<th>Category</th>
				<th>Description</th>
			</tr>

			<%
				for (Category category : categories) {
			%>

			<tr>
				<td><input type="checkbox" name="name" value="<%=category.getName()%>"></td>  
				<td><b><%=category.getName()%> </b></td><td><%=category.getDescription()%></td>
			</tr>

			<%
				}
			%>

		</table>
	
			<input type="submit" value="Delete Selected" name="deleteSelected" class="btn btn btn-success">
		

	</form></fieldset></div>

	<br>

<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script src="../dist/js/bootstrap.min.js"></script>



</body>
</html>