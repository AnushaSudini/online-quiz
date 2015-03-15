<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,edu.memphis.quizemon.model.Category"%>
<%
	List<Category> categories = (List<Category>)request.getAttribute("categories");
List<Category> activeCategories = (List<Category>)request.getAttribute("activeCategories");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quiz Categories</title>
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
						href="<%=request.getServletContext().getContextPath() %>/home.do">Home</a></li>
					<li><a
						href="<%=request.getServletContext().getContextPath() %>/logout.do">Log
							out</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li><a
						href="<%=request.getServletContext().getContextPath()%>/quiz/index.do">Choose
							a Category</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h1>List of Quiz Categories</h1>



				<% if (request.isUserInRole("master")){ %>
				<form action="" method="post">

			<table border="1" class="table">

				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>Current Status</th>
					<th>Deactivate</th>
				</tr>

				<%
				for (Category c : categories) {
			%>

				<tr>
					<td><a
						href="<%=application.getContextPath()%>/quiz/show.do?name=<%=c.getName()%>"><%=c.getName()%></a></td>
					<td><%=c.getDescription()%></td>
					<td><%=c.getStatus() %></td>
					<td><%if(c.getStatus().equals("active")){ %>
					<a href="<%=application.getContextPath() %>/quiz/deactivateCategory.do?categoryName=<%=c.getName()%>">Deactivate</a>
				<%} else { %>
					Add questions to make the category active. To add questions please select the category
				<% } %></td></tr>

				<%
				}
			%>

			</table>

		</form>
				
		<p>
			<a href="<%=application.getContextPath()%>/quiz/createForm.do">Create
				Category</a> | <a
				href="<%=application.getContextPath()%>/quiz/deleteForm.do">Delete
				Category</a>
		</p>
		<% } else if(request.isUserInRole("trainer")){%>
		<form action="" method="post">

			<table border="1" class="table">

				<tr>
					<th>Name</th>
					<th>Description</th>
					
				</tr>

				<%
				for (Category c : activeCategories) {
			%>

				<tr>
					<td><a
						href="<%=application.getContextPath()%>/quiz/show.do?name=<%=c.getName()%>"><%=c.getName()%></a></td>
					<td><%=c.getDescription()%></td>
					
				</tr>

				<%
				}
			%>

			</table>

		</form>
		
		<h4>Choose a category to start the quiz</h4>
		<%} %>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script src="../dist/js/bootstrap.min.js"></script>


</body>
</html>