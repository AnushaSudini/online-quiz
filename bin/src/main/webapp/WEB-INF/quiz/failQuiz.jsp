<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quiz | Fail Quiz</title>
<link href="../bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/dashboard.css" rel="stylesheet">
  </head>
  <body>
  	<%@ include file="/WEB-INF/header&&navigation.jspf"%>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h1>Sorry! You fail the quiz, now you can <a href="<%=application.getContextPath()%>/quiz/index.do">Try Again</a></h1>
	
    </div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
</body>
</html>