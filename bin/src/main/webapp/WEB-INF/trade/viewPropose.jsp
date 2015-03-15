<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,edu.memphis.quizemon.model.ProposeBean,edu.memphis.quizemon.model.Quizemon"%>
<%
	List<ProposeBean> propose = (List<ProposeBean>) request.getAttribute("propose");
	int trade_id = (Integer) request.getAttribute("trade_id");
%>
<!DOCTYPE>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Quizemon|Proposes Selected Trade</title>
    <link href="../bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/dashboard.css" rel="stylesheet">
</head>
<body>
	<%@ include file="/WEB-INF/header&&navigation.jspf"%>
	
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<div class="page-header">
  	<div class="container">
  		<div class="row-fluid">
		<h1>Propose Trade for selected Trade</h1>
      	</div>
  	</div>
	</div>
					
		<%
			for (ProposeBean p : propose) {
		%>
			<div class="panel panel-default">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h1 class="panel-title">
							ProposeID: <%=p.getProposeID() %>			  	
						</h1>	
				</div>
				<div class="panel-body">
					<table class="table">
					<%
						for (Quizemon q : p.getProposeQuizemon()) {	
					%>
					<tr>
						<td>
							<ul class="media-list">
								<li class="media">
						    		<a class="pull-left">
									<img  src="<%=request.getServletContext().getContextPath()%>/QuizemonDisplayImage.do?imgid=<%=q.getName()%>" border="0" width="170" height="170">
						    		</a>
						    	<div class="media-body">
						     	<h4 class="media-heading alert alert-danger">
						    	  	Name:<%=q.getName()%>
						      	</h4>
						      
						      	<ul class="list-group">
	  							  <li class="list-group-item list-group-item-success">Rareness: <%=q.getRareness()%></li>
	   							  <li class="list-group-item list-group-item-info">Weight: <%=q.getWeight()%> lbs.</li>
	  							  <li class="list-group-item list-group-item-warning">Special Power: <%=q.getSpecialpower()%></li>
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
			
		<%
			}
		%>		
			
			<form action="<%=application.getContextPath()%>/trade/acceptTradeForm.do" method="post">
		
				<input type="hidden" name="trade_id" value="<%=trade_id%>">
				<p class="lead"> 
					Accept trade: <input type="submit" value="Continue to accept propose">
				</p>
			</form>
			
			<form action="<%=application.getContextPath()%>/trade/declineTradeForm.do" method="post">
		
				<input type="hidden" name="trade_id" value="<%=trade_id%>">
				<p class="lead"> 
					Decline trade: <input type="submit" value="Continue to decline propose">
				</p>
				
			</form>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
</body>
</html>