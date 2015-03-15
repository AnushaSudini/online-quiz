<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,edu.memphis.quizemon.model.Category"%>

<%
	Category category = (Category) request.getAttribute("category");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quiz | Type of Quiz Question Form</title>
<link href="../bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="../css/dashboard.css" rel="stylesheet">
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand">Quizemon Trainer: <%=request.getRemoteUser()%></a>
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
		<legend>Choose type of Quiz Questions</legend>
		
		<form
			action="<%=application.getContextPath()%>/quiz/typeOfQuestion.do"
			method="post">
			<table border="0" class="table" >
			
			<tr><td style="border: 0px">	<b>Choose type of Question:</b>&nbsp;&nbsp; <select name="type">
						<option value="Multiple Choice Questions">Multiple Choice
							Questions</option>
						<option value="Spelling">Spelling</option>
						<option value="True or False">True or False</option>
						<option value="Fill in the blank">Fill in the blank</option>
				</select></td></tr>
			
			</table>
			<input type="hidden" id="" name="name"
				value='<%=category.getName()%>'>
			
				<input type="submit" value="select" class="btn btn btn-success">
					</form></fieldset>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script src="../dist/js/bootstrap.min.js"></script>

</body>
</html>