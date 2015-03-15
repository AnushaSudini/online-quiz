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
<title>Category Information</title>
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
		<form name="showCategory"
			action="<%=application.getContextPath()%>/quiz/createCategory.do"
			method="post">
			<fieldset>
			<legend>Category Information</legend>


			<h3 style="color: teal;"><%=category.getName()%></h3>

			<ul>
				<li>Description: <%=category.getDescription()%></li>
			</ul>
</fieldset>
		</form>
	</div>
	<%
		if (request.isUserInRole("master")) {
	%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li><a
						href="<%=application.getContextPath()%>/quiz/updateForm.do?name=<%=category.getName()%>">Update
							Category</a></li>

					<li><a
						href="<%=application.getContextPath()%>/quiz/questionType.do?categoryName=<%=category.getName()%>">Create
							Question</a></li>
					<li><a
						href="<%=application.getContextPath()%>/quiz/viewQuestionsByCategory.do?categoryName=<%=category.getName()%>">View
							Questions</a></li>
				</ul>
			</div>
		</div>
	</div>
	<%
		} else if (request.isUserInRole("trainer")) {
	%>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<form action="<%=application.getContextPath()%>/quiz/take.do"
			method="get">
			<h4>Choose difficulty level:</h4>
			<select name="difficulty">
				<option value="easy">easy</option>
				<option value="medium">medium</option>
				<option value="hard">hard</option>
			</select> <br /> <br /> <br /> <input type="hidden" id="" name="name"
				value='<%=category.getName()%>'> <input type="submit"
				value="Take a quiz" class="btn btn btn-success">


		</form>
	</div>
	<%
		}
	%>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script src="../dist/js/bootstrap.min.js"></script>


</body>
</html>