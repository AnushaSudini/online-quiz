<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List,edu.memphis.quizemon.model.Question"%>
    
    <% Question question = (Question) request.getAttribute("question"); %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quiz | Manage Quiz Questions </title>
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
<legend> Manage Quiz Questions  </legend>

<form action="" method="post">
  <table class="table">

<tr><th style="border: 0px"> Category Name:</th><td style="border: 0px"> <input type="text" name="name" value="<%=question.getQuestionCategory()%>" readonly="readonly"></td></tr>
<tr> <th style="border-top: 0px">Type of Question:</th><td style="border: 0px"><input type="text" size="30" name="type" value="<%=question.getQuestionType() %>" readonly="readonly"></td></tr>
</table>
<div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
<li><a href="<%=application.getContextPath() %>/quiz/createQuestion.do?categoryName=<%=question.getQuestionCategory()%>&questionType=<%=question.getQuestionType()%>">Create Question</a>
</li></ul></div></div></div>
</form></fieldset></div>
<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script src="../dist/js/bootstrap.min.js"></script>

</body>
</html>