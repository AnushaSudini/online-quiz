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
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Quizemon|Decline Trade</title>

    <link href="../bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <link href="../css/dashboard.css" rel="stylesheet">

</head>
<body>
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

	<div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
			<li><a href="<%=request.getServletContext().getContextPath()%>/quiz/index.do">Take quiz</a></li>
			<li><a href="<%=request.getServletContext().getContextPath()%>/TradingPost.do">Trading Post</a></li>
			<li><a href="<%=request.getServletContext().getContextPath()%>/coin/showCoins.do">Show Coins</a></li>
			<li><a href="<%=request.getServletContext().getContextPath()%>/quizemons/showQuizemons.do">Show Zoo</a></li>
          	<li>
          		<div class="btn-group">
  				<button class="btn btn-default btn-lg dropdown-toggle" type="button" data-toggle="dropdown">
    				Show Trade and Propose <span class="caret"></span>
  				</button>
  				<ul class="dropdown-menu">
    				<li> <a href="<%=request.getServletContext().getContextPath()%>/trade/showTradeByUser.do"> All the trades </a></li>
    				<li> <a href="<%=request.getServletContext().getContextPath()%>/trade/showProposeByUser.do">All the proposes </a></li>
 				</ul>
				</div>
          	</li>
          </ul>
        </div>
	 </div>
	</div>
	
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h1>Decline-Trade Form</h1>

	<p>Use this form to decline trades.</p>

	<form action="<%=application.getContextPath()%>/trade/declineTrade.do"
		method="post">

		<p>
			<input type="submit" value="Delete Selected" name="deleteSelected">
		</p>

		<table border="1">

			<tr>
				<th>&times;</th>
				<th>Trade</th>
			</tr>

			<%
				for (ProposeBean p : propose) {
			%>

			<tr>
				<td><input type="checkbox" name="id" value="<%=p.getProposeID()%>"></td>
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