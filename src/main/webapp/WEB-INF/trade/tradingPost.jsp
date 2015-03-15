<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->




<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>QUIZEMON | TRADING POST</title>
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
			<li><a href="<%=request.getServletContext().getContextPath()%>/TradingPost.do">Trading Post</a></li>
			<li><a href="<%=request.getServletContext().getContextPath()%>/coin/showCoins.do">Show Coins</a></li>
			<li><a href="<%=request.getServletContext().getContextPath()%>/quizemons/showQuizemons.do">Show Quizemons</a></li>
          	<li><a href="<%=request.getServletContext().getContextPath()%>/trade/showTrade&Propose.do">Show Trade and Propose</a></li>
          </ul>
        </div>
	 </div>
	</div>
	
		<div class="col-sm-4 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header" >READY FOR TRADE??</h1>
           <h2 class="page-header">GO FOR IT!!!</h2>
   
    <div class="col-sm-4 col-sm-offset-3 col-md-4 col-md-offset-2 main">


 <form action="<%=application.getContextPath()%>/OfferTrade.do"
		method="post">

		<p>
			<input type="submit" value="Offer Trade" name="offerTrade"  class="btn btn-lg btn-success btn-block">
		</p>
</form>

<form action="<%=application.getContextPath()%>/ProposeTradeFormServlet.do"
		method="post">

		<p>
			<input type="submit" value="Propose Trade" name="viewTrade"  class="btn btn-lg btn-success btn-block">
		</p>
</form>
 <form action="<%=application.getContextPath()%>/ViewTradeFormServlet.do"
		method="post">

		<p>
			<input type="submit" value="View/Withdraw Offers" name="viewTrade"  class="btn btn-lg btn-success btn-block">
		</p>
</form>

  
 <form action="<%=application.getContextPath()%>/ViewProposeTradeServlet.do"
		method="post">

		<p>
			<input type="submit" value="View/Withdraw Proposals" name="proposeTrade" class="btn btn-lg btn-success btn-block">
		</p>
		
</form> 
	

	
	 </div>
	 </div>


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="dist/js/bootstrap.min.js"></script>
</body>
</html>
