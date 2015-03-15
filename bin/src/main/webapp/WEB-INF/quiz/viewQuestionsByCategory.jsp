<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List,edu.memphis.quizemon.model.Question"%>
    <%
	List<Question> question = (List<Question>) request.getAttribute("question");
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Questions</title>
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
                <li><a href="<%=request.getServletContext().getContextPath() %>/home.do">Home</a></li>
                <li><a href="<%=request.getServletContext().getContextPath() %>/logout.do">Log out</a></li>
              </ul>
            </div>
      </div>
    </div>
<fieldset>
<legend>Questions</legend>

	
	<table border="1" class="table">
<tr>
			<th>ID</th>
			<th>Category</th>
			<th>Question</th>
			<th>Difficulty Level</th>
			<th>Type of Question</th>
			<th>Update Question</th>
			<th>Delete Question</th>
		</tr>

		<%
			for (Question q : question) {
		%>

		<tr>
			<td><%=q.getQuestionId()%></td>
			<td><%=q.getQuestionCategory()%></td>
			<td><%=q.getQuestionContent()%></td>
			<td><%=q.getQuestionDifficulty()%></td>
			<td><%=q.getQuestionType()%></td>
		<td><a href="<%=application.getContextPath() %>/quiz/updateQuestion.do?questionId=<%=q.getQuestionId()%>">Edit</a></td>
		<td><a href="<%=application.getContextPath() %>/quiz/deleteQuestion.do?questionId=<%=q.getQuestionId()%>&questionCategory=<%=q.getQuestionCategory()%>">Delete</a></td>	
		</tr>

		<%
			}
		%>
		</table></fieldset>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script src="../dist/js/bootstrap.min.js"></script>
	
</body>
</html>