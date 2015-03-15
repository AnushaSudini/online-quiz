<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,edu.memphis.quizemon.model.Quizemon"%>
<%
	List<Quizemon> quizemons = (List<Quizemon>) request.getAttribute("quizemons");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
<title>Quizemon | Quizemon Index</title>
<!-- Bootstrap core CSS -->
    <link href="../bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../css/dashboard.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body onload="windows.reload()">
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

	<div class="panel panel-default">
			  <!-- Default panel contents -->
			  <div class="panel panel-primary">
			  <div class="panel-heading">
			  	<h1 class="panel-title">Quizemon Index</h1></div>
		
	<table border="1" class="table">	
				<%
					for (Quizemon p : quizemons) {
				%>
		
				<tr>
					<td>
					<ul class="media-list">
						  <li class="media">
						    <a class="pull-left">
						      <img class="media-object" src="<%=request.getServletContext().getContextPath()%>/QuizemonDisplayImage.do?imgid=<%=p.getName()%>" border="0" width="170" height="170">
						    </a>
						    <div class="media-body">
						      <h4 class="media-heading alert alert-danger">
						    	  	Name: <a href="<%=application.getContextPath()%>/quizemons/show.do?name=<%=p.getName()%>"><%=p.getName()%>
					</a>
						      </h4>
						      
						      <ul class="list-group">
	  							  <li class="list-group-item list-group-item-success">Price: <%=p.getPrice()%></li>
	  							  <li class="list-group-item list-group-item-success">Rareness: <%=p.getRareness()%></li>
	   							  <li class="list-group-item list-group-item-info">Weight: <%=p.getWeight()%> lbs.</li>
	  							  <li class="list-group-item list-group-item-warning">Special Power: <%=p.getSpecialpower()%>
	  							  </li>
							  </ul>
						   </div>
						  </li>
						</ul>
					</td>
				</tr>
		
				<%
					}
				%>
		</table>
	 	</div>
	 	</div>	
	<p>
		<a href="<%=application.getContextPath()%>/quizemons/createForm.do">Create Quizemon</a> |
		<a href="<%=application.getContextPath()%>/quizemons/deleteForm.do">Delete Quizemon</a>
	</p>

    </div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="../dist/js/bootstrap.min.js"></script>	</body>	
</body>
</html>