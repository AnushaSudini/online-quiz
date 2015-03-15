<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,edu.memphis.quizemon.model.Quizemon"%>
<%
	List<Quizemon> quizemons = (List<Quizemon>) request.getAttribute("quizemons");
%>
<%
	int usercoins = (Integer)request.getAttribute("usercoins");
%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quiz | Enter Store</title>
<script type="text/javascript">
function jarod(price, usercoins)
 {
	if (price > usercoins){
    	alert('You have no enough money!');
	}
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
			  	<h1 class="panel-title">Quizemon Store</h1></div>
		
	<form action="<%=application.getContextPath()%>/quiz/buyQuizemon.do" method="post">
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
						      <input type="radio" name="quizemonInfo" onfocus="jarod(<%=p.getPrice()%>, <%=usercoins%>);" value='<%=p.getName()%>:<%=p.getPrice()%>' required>
						    	  	Name: <%=p.getName()%>
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
		<p><input type="submit" value="Buy Selected" name="buySelected"></p>
	</form>	
    </div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
</html>