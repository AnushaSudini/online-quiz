<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,edu.memphis.quizemon.model.QuizMultipleChoiceQuestion,edu.memphis.quizemon.model.Question,edu.memphis.quizemon.model.Answer,javax.servlet.http.HttpSession"%>
<%
	QuizMultipleChoiceQuestion quiz = (QuizMultipleChoiceQuestion) request.getAttribute("quiz");
	int p = (Integer) session.getAttribute("page");
	
    session.setAttribute("page", p+1);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quiz | Take Quiz</title>
<script type="text/javascript">
function jarod(count, content)
 {
	System.out.println("fuzhi session");
	HttpSession session=request.getSession();  
    session.setAttribute("answer", content);
 }
</script>
    <link href="../bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/dashboard.css" rel="stylesheet">
  </head>
  <body>
  	<%@ include file="/WEB-INF/header&&navigation.jspf"%>
  	
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<div class="panel panel-default">
			  <!-- Default panel contents -->
			  <div class="panel panel-primary">
			  <div class="panel-heading">
			  	<h1 class="panel-title">Take Quiz</h1></div>
	<div class="media-body">
	<h4 class="media-heading alert alert-danger">Quiz topic: <%=quiz.getQuestion().getQuestionCategory()%> | This question's difficult level: <%=quiz.getQuestion().getQuestionDifficulty()%></h4></div>
	<%if (p < 10) { %>
		<form action="<%=application.getContextPath()%>/quiz/accept.do" method="post">	
	<%} else { %>	
		<form action="<%=application.getContextPath()%>/quiz/submit.do" method="post">	
	<%} %>
		<%
			Question q = quiz.getQuestion();
			Answer a = quiz.getAnswers();
			if (q.getQuestionType().equals("Multiple Choice Questions")) {
		%>
			<%=p%>. <%=q.getQuestionContent() %><br>
			<p><input type="radio" name="answer" value='<%=p %>:<%=q.getQuestionType() %>:<%=a.getoption1()%>:<%=a.getanswer() %>:<%=q.getQuestionDifficulty() %>'><%=a.getoption1()%></p>
			<p><input type="radio" name="answer" value='<%=p %>:<%=q.getQuestionType() %>:<%=a.getoption2()%>:<%=a.getanswer() %>:<%=q.getQuestionDifficulty() %>'><%=a.getoption2()%></p>
			<p><input type="radio" name="answer" value='<%=p %>:<%=q.getQuestionType() %>:<%=a.getoption3()%>:<%=a.getanswer() %>:<%=q.getQuestionDifficulty() %>'><%=a.getoption3()%></p>
			<p><input type="radio" name="answer" value='<%=p %>:<%=q.getQuestionType() %>:<%=a.getoption4()%>:<%=a.getanswer() %>:<%=q.getQuestionDifficulty() %>'><%=a.getoption4()%></p>

		<%
			}else if(q.getQuestionType().equals("True or False")){
		%>
			<%=p%>. <%=q.getQuestionContent() %><br>
			<p><input type="radio" name="answer" value='<%=p %>:<%=q.getQuestionType() %>:True:<%=a.getanswer() %>:<%=q.getQuestionDifficulty() %>'>True</p>
			<p><input type="radio" name="answer" value='<%=p %>:<%=q.getQuestionType() %>:False:<%=a.getanswer() %>:<%=q.getQuestionDifficulty() %>'>False</p>
		
		<%
			}else if(q.getQuestionType().equals("Fill in the blank")){
		%>
			<%=p%>. <%=q.getQuestionContent() %><br>
			<input type="hidden" name="answer" value='<%=p %>:<%=q.getQuestionType() %>:<%=a.getanswer() %>:<%=q.getQuestionDifficulty() %>'>
			<p>Answer: <input type="text" name="answercontent" value=''></p>	
		<%
			}else if (q.getQuestionType().equals("Spelling")){
		%>
			<%=p%>. <%=q.getQuestionContent() %><br>
				<p><input type="radio" name="answer" value='<%=p %>:<%=q.getQuestionType() %>:<%=a.getoption1()%>:<%=a.getanswer() %>:<%=q.getQuestionDifficulty() %>'><%=a.getoption1()%></p>
				<p><input type="radio" name="answer" value='<%=p %>:<%=q.getQuestionType() %>:<%=a.getoption2()%>:<%=a.getanswer() %>:<%=q.getQuestionDifficulty() %>'><%=a.getoption2()%></p>
				<p><input type="radio" name="answer" value='<%=p %>:<%=q.getQuestionType() %>:<%=a.getoption3()%>:<%=a.getanswer() %>:<%=q.getQuestionDifficulty() %>'><%=a.getoption3()%></p>
				<p><input type="radio" name="answer" value='<%=p %>:<%=q.getQuestionType() %>:<%=a.getoption4()%>:<%=a.getanswer() %>:<%=q.getQuestionDifficulty() %>'><%=a.getoption4()%></p>
				
		<%
			}
		%>	
		
		<p>
			<input type="submit" value="submit">
		</p>
	</form>
	
    </div>
    </div>
    </div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
</body>
</html>