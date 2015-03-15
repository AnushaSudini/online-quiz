<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="edu.memphis.quizemon.model.Quizemon"%>
<%
	Quizemon quizemon = (Quizemon) request.getAttribute("quizemon");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quizemon | Quizemon-Update Success</title>
<!-- Bootstrap core CSS -->
    <link href="../bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../css/dashboard.css" rel="stylesheet">

</head>
<body>
  <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand">Quizemon Master: <%=request.getRemoteUser()%></a>
        </div>
         <div class="navbar-collapse collapse">
              <ul class="nav navbar-nav navbar-right">
                <li><a href="<%=request.getServletContext().getContextPath() %>/home.do">Home</a></li>
                <li><a href="<%=request.getServletContext().getContextPath() %>/logout.do">Log out</a></li>
              </ul>
            </div>
      </div>
    </div>

	<div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
			<li><a href="<%=request.getServletContext().getContextPath()%>/quizemons/index.do">Quizemon</a></li>
			<li><a href="<%=request.getServletContext().getContextPath()%>/quiz/index.do">Choose a Category</a></li>
          </ul>
        </div>
	 </div>
	</div>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

	<h1>Update-Quizemon Success</h1>
	
	<p>Update Quizmon <%=quizemon.getName() %> successfully!</p>
		
    </div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="../dist/js/bootstrap.min.js"></script>	</body>	
</body>
</html>