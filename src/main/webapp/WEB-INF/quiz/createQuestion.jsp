<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List,edu.memphis.quizemon.model.Question"%>
    
    <!--  Category category = (Category) request.getAttribute("category"); %>-->
    <% Question question = (Question) request.getAttribute("question"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quiz | Create Quiz Question Form</title>
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
    
<form action="<%=application.getContextPath()%>/quiz/formQuestion.do" method="post">
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
<fieldset>
<legend> Create Quiz Question Form </legend>
<table border="0" class="table" >

<tr><th style="border: 0px"> Name: </th><td style="border: 0px"><input type="text" name="name" value="<%=question.getQuestionCategory()%>" readonly="readonly"></td></tr>
 <tr><th style="border: 0px">Question Type:</th><td style="border: 0px"> <input type="text" size="30" name="type" value="<%=question.getQuestionType()%>" readonly="readonly"></td></tr>
 <tr><th style="border: 0px">Enter Question:</th><td style="border: 0px"> <input type="text" name="question" size="100" value=""></td></tr>
<tr><th style="border: 0px"> Enter difficulty level:</th><td style="border: 0px"> <input type="text" name="difficulty" value=""></td></tr>
<% if(question.getQuestionType().equals("Multiple Choice Questions")||question.getQuestionType().equals("Spelling")){ %>
<tr><th style="border: 0px"> Enter Option1: </th><td style="border: 0px"><input type="text" name="option1"></td></tr>
<tr><th style="border: 0px"> Enter Option2:</th><td style="border: 0px"> <input type="text" name="option2"></td></tr>
<tr><th style="border: 0px"> Enter Option3:</th><td style="border: 0px"> <input type="text" name="option3"></td></tr>
<tr><th style="border: 0px"> Enter Option4:</th><td style="border: 0px"> <input type="text" name="option4"></td></tr>
<tr><th style="border: 0px"> Enter Answer: </th><td style="border: 0px"><input type="text" name="answer"></td></tr>
<%}
else if(question.getQuestionType().equals("Fill in the blank")){%>
<tr><th style="border: 0px">	 Enter Answer:</th><td style="border: 0px"> <input type="text" name="answer"></td></tr>

<%}
else if(question.getQuestionType().equals("True or False")){ %>
<tr><th style="border: 0px">Select Answer:</th><td style="border: 0px">  <input type="radio" name="bool" value="True">True
<input type="radio" name="bool" value="False">False</td></tr>
<%} %>
<!-- <input type="hidden" name="questionType" value='<=question.getQuestionType()>>' -->
</table></fieldset></div>
<input type="submit" value="create" class="btn btn btn-success" style="margin-left: 500px">
</form>
<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script src="../dist/js/bootstrap.min.js"></script>

</body>
</html>