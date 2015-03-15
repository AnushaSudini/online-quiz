<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import="java.util.List,edu.memphis.quizemon.model.TradeInfo"%>
<%@ page import="java.util.List,edu.memphis.quizemon.model.Quizemon"%>
<%@ page import="java.util.List,edu.memphis.quizemon.model.Trade"%>
<%@ page import="java.util.List,edu.memphis.quizemon.model.TradeBean"%>
 <%
	List<TradeInfo> tradeInfoList = (List<TradeInfo>)request.getAttribute("tradeInfoList");
  List<Quizemon> qList = (List<Quizemon>)request.getAttribute("qList"); 
  List<String> userList =(List<String>)request.getAttribute("list");
  List<TradeBean> bean = (List<TradeBean>)request.getAttribute("tr");
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">    
    <!-- Bootstrap core CSS -->
    <link href="./bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="./css/dashboard.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script> <![endif]-->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<title>Insert title here</title>  </head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand">Quizemon Trainer: <%=request.getRemoteUser()%></a>
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
			<li><a href="<%=request.getServletContext().getContextPath()%>/TradingPost.do">Trading</a></li>
			<li><a href="<%=request.getServletContext().getContextPath()%>/coin/showCoins.do">Show Coins</a></li>
			<li><a href="<%=request.getServletContext().getContextPath()%>/quizemons/showQuizemons.do">Show Quizemons</a></li>
          	<li><a href="<%=request.getServletContext().getContextPath()%>/trade/showTrade&Propose.do">Show Trade and Propose</a></li>
          </ul>
        </div>
	 </div>
	</div>
	
		<div class="col-sm-4 col-sm-offset-3 col-md-9 col-md-offset-2 main">
<h1>Propose Trade </h1>
		<table class="table table-bordered table-hover">
	<tr align="center">
				<th>Trade Id</th>
				<th> Trainers </th>
				<th>Quizemon Name</th>
				<th>Image </th>
				<th> Action </th>
			</tr>

			<%int i=0;
				for (TradeInfo tr : tradeInfoList) {
					System.out.println("PROPOSE TRADE FORM JSP");
			%> 
		
			
				 <%
				for (Quizemon q : qList) {
					
			%> 
			
			<tr align="center">
				 
				<td><%=tr.getID()%><input type="hidden" name="tradeid" value="<%=tr.getID()%>">  </td> 
				 <td><%=userList.get(i) %></td> 
				 <td><%=tr.getQuizemon()%> </td>
				<td><img  src="<%=request.getServletContext().getContextPath()%>/QuizemonDisplayImage.do?imgid=<%=tr.getQuizemon()%>" border="0" width="100" height="100" align="middle"></td> 
			 <td> 
          <%if(!(request.getRemoteUser().equals(userList.get(i)))){ %>
           <a href="<%=request.getContextPath()%>/ProposeTradeServlet.do?id=<%=tr.getID() %>" class="btn btn btn-primary" > <button type="button" class="btn btn-success">Propose Trade  </button> </a> </td>
			
			
			 <%
				}
			else
			{%>
				<td> </td>
			<% }%>
			</tr>
			 <%
				}
			%>


			<%
				++i;}
			%>

		</table>
   </form>

	<br>

	
</div>
<footer class="foot-copyright">
        <p>&copy; Troika 2014 </p>
    </footer> 

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="dist/js/bootstrap.min.js"></script>
    </body>
</html> 