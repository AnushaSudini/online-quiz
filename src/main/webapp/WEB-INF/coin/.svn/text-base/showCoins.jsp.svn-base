<%@ page import="java.util.List,edu.memphis.quizemon.model.Quizemon"%>
<%
	int coins = (Integer)request.getAttribute("user_coin");
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Quizemon|Trainer Coins</title>
    <link href="../bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/dashboard.css" rel="stylesheet">
  </head>
  <body>
  	<%@ include file="/WEB-INF/header&&navigation.jspf"%>
	
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<div class="panel panel-primary">
			<div class="panel-heading">
			  	<h1 class="panel-title">
			  		Current Coins you have: 
			  	</h1>	
			</div>
			<div class="panel-body">
				<%=coins%>
        	</div>
		</div>
	</div>	
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
</body>
</html>
