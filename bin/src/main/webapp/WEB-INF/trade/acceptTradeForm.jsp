<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List,edu.memphis.quizemon.model.ProposeBean,edu.memphis.quizemon.model.Quizemon"%>
<%
	List<ProposeBean> propose = (List<ProposeBean>) request.getAttribute("propose");	
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Quizemon|Accept Trade</title>
    <link href="../bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/dashboard.css" rel="stylesheet">
</head>
<body>
	<%@ include file="/WEB-INF/header&&navigation.jspf"%>
	
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<div class="page-header">
  	<div class="container">
  		<div class="row-fluid">
		<h1>Accept-Trade Form</h1>
      	</div>
  	</div>
	</div>

	<p class="lead">Use this form to Accpet trades.</p>
	<p class="lead">Notice, when you choose to accept a trade, others trades will be declined automatically.</p>

	<form action="<%=application.getContextPath()%>/trade/acceptTrade.do"
		method="post">

		<p>
			<input type="submit" value="Accept Selected" name="acceptSelected">
		</p>

		<table class="table">

			<tr>
				<th>&times;</th>
				<th>Trade</th>
			</tr>

			<%
				for (ProposeBean p : propose) {
			%>

			<tr>
				<td><input type="radio" name="id" value="<%=p.getProposeID()%>" required></td>
				<td>propose <%=p.getProposeID()%> proposed by <%=p.getUser()%></td>
			</tr>

			<%
				}
			%>

		</table>

	</form>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>

</body>
</html>