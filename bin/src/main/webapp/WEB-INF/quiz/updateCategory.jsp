<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="edu.memphis.quizemon.model.Category"%>
<%
	Category category = (Category) request.getAttribute("category");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quiz | Update Quiz Category Form</title>
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

		

		<form
			action="<%=application.getContextPath()%>/quiz/updateCategory.do"
			method="post">
			<fieldset>
				<legend>Update Category Information</legend>
				<input type="hidden" name="name" value="<%=category.getName()%>"></input>
				
				<table border="0" class="table" >
				
				<tr><th style="border: 0px">Old Name:</th><td style="border: 0px"><input
						type="text" name="name" value="<%=category.getName()%>"></input></td></tr>
				<tr><th style="border: 0px"> Name: </th><td style="border: 0px"><input type="text"
						name="newName" value=""></input></td></tr>
				<tr><th style="border: 0px;">Description:</th><td style="text-align: left;border: 0px;">
					<textarea rows="10" cols="40" name="info">
					<%=category.getDescription()%></textarea></td></tr>
				</table>
					<input type="submit" value="update" class="btn btn btn-success">
			
			</fieldset>
		</form>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script src="../dist/js/bootstrap.min.js"></script>
</body>
</html>