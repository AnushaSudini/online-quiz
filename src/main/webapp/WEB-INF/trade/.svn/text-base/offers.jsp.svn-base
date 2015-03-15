<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import= "java.util.ArrayList,edu.memphis.quizemon.model.Trade"%>
    <%@ page import= "java.util.List,edu.memphis.quizemon.model.TradeInfo"%>
     <%@ page import= "java.util.List,edu.memphis.quizemon.model.TradeBean"%>
     <%@ page import="java.util.List,edu.memphis.quizemon.model.Quizemon"%>
  <%
	List<TradeInfo> tradeinformation = (List<TradeInfo>) request.getAttribute("tradeInformation");
    List<String> userList =(List<String>)request.getAttribute("list");
    List<TradeBean> bean = (List<TradeBean>)request.getAttribute("tr");
    List<Quizemon>  qList = (List<Quizemon>)request.getAttribute("qList");
    ArrayList<String> reasons = (ArrayList<String>) request.getAttribute("reasons");
    
    
   
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Offers</title>
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

</head>
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
	
		<div class="col-sm-4 col-sm-offset-3 col-md-10 col-md-offset-2 main">

	<h1 align="center">Trades List</h1>
	
		<br>
		
<table class="table table-bordered table-hover table-striped">
		<tr>		
	 <th> Trade Id </th> 
	 <th> Trainer </th>
		<th> Quizemon Offered </th>
		<th> Image </th>
		<th> Reason for Offer </th>
	</tr>
		 <%
	  int j=0;
			for (TradeBean b : bean) {
				System.out.println("OFFERS JSP:"+userList.get(0));
		%>  
		<%
				for (Quizemon q : b.getQuizemon()) {
					
			%>
	
	<tr>
			 <td align="center"><%=b.getID() %></td>
			 <td align="center"><%=b.getUser()%></td> 
			 <td align="center"><%=q.getName() %></td> 
	 <td> <img  src="<%=request.getServletContext().getContextPath()%>/QuizemonDisplayImage.do?imgid=<%=q.getName()%>" border="0" width="100" height="100" align="middle"></td> 
			  	<%if(reasons.get(j)!=null){ %>
			  	<td  align="center"> <%=reasons.get(j) %></td>
			  	<%j++; }
			  	else
			  		{%>
			  		<td  align="center">Please take my quizemon </td>
			  		<% j++;}%>
</tr>
<%
			}
		%>  

	
  <%
		}
		%>  

	</table>
<br>
</div>


</body>
</html>  