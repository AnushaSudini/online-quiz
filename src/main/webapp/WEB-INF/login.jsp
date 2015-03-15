<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Quizemon|Home</title>

    <link href="bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <link href="css/sign.css" rel="stylesheet">

  </head>

  <body>

    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <a class="navbar-brand">Quizemon</a>
        </div>
      </div>
    </div>

    <div class="jumbotron">
      <div class="container">
        <h1>	Welcome to the Quizemon World!</h1>
      </div>
    </div>

    <div class="container">    
            <h2 class="form-signin-heading">Sign in:</h2>       
            <form class= "form-signin" method="post" action="j_security_check">
			<input class="form-control" type="text" name="j_username" placeholder="Account Name" required autofocus>
			<input class="form-control" type="password" name="j_password" placeholder="Password" required>
			<input class="btn btn-lg btn-primary btn-block" type="submit" value="Sign in">
	</form>
	</div>
	<div>
    <hr>

    <footer class="foot-copyright">
        <p>&copy; Troika 2014 </p>
    </footer>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="dist/js/bootstrap.min.js"></script>
  </body>
</html>
