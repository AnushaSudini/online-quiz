<%@ page import="java.util.List,edu.memphis.quizemon.model.Quizemon"%>
<%
	List<Quizemon> quizemons = (List<Quizemon>) request.getAttribute("user_quizemons");
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Quizemon|Show Zoo</title>

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
			  	<h1 class="panel-title">
			  		Current Quizemon you have: 
			  	</h1>	
			  </div>
			  <table class="table">
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
						    	  	Name:<%=p.getName()%>
						      </h4>
						      
						      <ul class="list-group">
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
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
</body>
</html>