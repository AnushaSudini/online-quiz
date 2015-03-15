<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="edu.memphis.quizemon.model.Question,edu.memphis.quizemon.model.Answer"%>
<%
	Question question = (Question) request.getAttribute("question");
	Answer answers = (Answer) request.getAttribute("answers");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Question Form</title>
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



		<form action="<%=application.getContextPath()%>/quiz/editQuestion.do"
			method="post">
			<fieldset>
				<legend>Update Question</legend>
				<input type="hidden" name="qID"
					value="<%=question.getQuestionId()%>">
				<table border="0" class="table">

					<tr>
						<th style="border: 0px">Question ID:</th>
						<td style="border: 0px"><input type="text" name="qID"
							value="<%=question.getQuestionId()%>" readonly="readonly"></td>
					</tr>
					<tr>
						<th style="border: 0px">Question Category:</th>
						<td style="border: 0px"><input type="text" name="category"
							value="<%=question.getQuestionCategory()%>"></td>
					</tr>
					<tr>
						<th style="border: 0px">Question:</th>
						<td style="border: 0px"><input type="text" name="content"
							size="100" value="<%=question.getQuestionContent()%>"></td>
					</tr>
					<tr>
						<th style="border: 0px">Question Difficulty:</th>
						<td style="border: 0px"><input type="text" name="difficulty"
							value="<%=question.getQuestionDifficulty()%>"></td>
					</tr>
					<tr>
						<th style="border: 0px">Question Type:</th>
						<td style="border: 0px"><input type="text" name="type"
							size="30" value="<%=question.getQuestionType()%>" readonly="readonly"></td>
					</tr>

					<%
						if (question.getQuestionType().equals("Multiple Choice Questions")
								|| question.getQuestionType().equals("Spelling")) {
					%>

					<tr>
						<th style="border: 0px">Enter Option1:</th>
						<td style="border: 0px"><input type="text" name="option1"
							value="<%=answers.getoption1()%>"></td>
					</tr>
					<tr>
						<th style="border: 0px">Enter Option2:</th>
						<td style="border: 0px"><input type="text" name="option2"
							value="<%=answers.getoption2()%>"></td>
					</tr>
					<tr>
						<th style="border: 0px">Enter Option3:</th>
						<td style="border: 0px"><input type="text" name="option3"
							value="<%=answers.getoption3()%>"></td>
					</tr>
					<tr>
						<th style="border: 0px">Enter Option4:</th>
						<td style="border: 0px"><input type="text" name="option4"
							value="<%=answers.getoption4()%>"></td>
					</tr>
					<tr>
						<th style="border: 0px">Enter Answer:</th>
						<td style="border: 0px"><input type="text" name="answer"
							value="<%=answers.getanswer()%>"></td>
					</tr>
					<%
						} else if (question.getQuestionType().equals("Fill in the blank")) {
					%>
					<tr>
						<th style="border: 0px">Enter Answer:</th>
						<td style="border: 0px"><input type="text" name="answer"
							value="<%=answers.getanswer()%>"></td>
					</tr>

					<%
						} else if (question.getQuestionType().equals("True or False")) {
							String answer = answers.getanswer();
							if (answer.equals("true")) {
					%>
					<tr>
						<th style="border: 0px">Select Answer:</th>
						<td style="border: 0px"><input type="radio" name="bool"
							value="True" checked>True <input type="radio" name="bool"
							value="False">False</td>
					</tr>

					<%
						} else {
					%>

					<tr>
						<th style="border: 0px">Select Answer:</th>
						<td style="border: 0px"><input type="radio" name="bool"
							value="True">True <input type="radio" name="bool"
							value="False" checked>False</td>
					</tr>
					<%
						}
						}
					%>





				</table>
			</fieldset>
			
				<input type="submit" value="update" class="btn btn btn-success">
			

		</form>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script src="../dist/js/bootstrap.min.js"></script>


</body>
</html>