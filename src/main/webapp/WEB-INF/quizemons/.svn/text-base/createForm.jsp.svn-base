<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quizemon | Quizemon-Create Form</title>
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
<body>
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

	<h1>Create-Quizemon Form</h1>
	
	<p>Use this form to create a new quizemon.</p>
	<form action="<%=application.getContextPath()%>/quizemons/create.do" method="post" enctype="multipart/form-data">
		<ul>
			<li>Name:     <input type="text" name="name" value=""></li>
			<li>Price:    <input type="text" name="price" value=""></li>
			<li>Rareness: 
				<select name="rareness">
					<option value="noChoice" selected>--Choose One--</option>
					<option value="Common">Common</option>
					<option value="Medium">Medium</option>
					<option value="Rare">Rare</option>
				</select></li>
			<!--<li>Rareness: <input type="text" name="rareness" value=""></li>-->
			<li>Weight:   <input type="text" name="weight" value=""></li>
			<li>Special power: <input type="text" name="specialpower" value=""></li>            
            <li>Select a image to upload: <br />
                            <input type="file" id="upfile" name="upfile"/>                               
		</ul>
		<p>
			<input type="submit" value="Create">
		</p>
	</form>
	
    </div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="../dist/js/bootstrap.min.js"></script>	</body>
</body>
</html>