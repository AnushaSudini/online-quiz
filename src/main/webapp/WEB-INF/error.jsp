<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Error</title>
</head>
<body>

	<h1>Login Error!</h1>

	<p>Bad username and/or password.</p>

	<p>
		<a href="<%=request.getServletContext().getContextPath()%>/">Try
			again</a>
	</p>

</body>
</html>
