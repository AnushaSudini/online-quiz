<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List,edu.memphis.quizemon.model.UserQuizemon"%>

<%@ page import="java.util.List,edu.memphis.quizemon.model.TradeInfo"%>
 <%
	List<UserQuizemon> listItemsToPost = (List<UserQuizemon>) request.getAttribute("listItemsToPost");
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quizemon Offer Trade</title>
</head>
<body>
<h1> Offer Quizemons Form</h1>
<h2> Select one the available quizemons for offering trade</h2>
<form action="<%=application.getContextPath()%>/SubmitOffer.do"
		method="post">
		<p>
			<input type="submit" value="Offer Quizemon">
		</p>

<%-- <ul>
	<li>Quizemon Name:
	        <%
				for (UserQuizemon li : listItemsToPost) {
			%>
	
			<select name="quizemon_name">
	<c:forEach items = "${listItemsToPost}" var= "listItemsToPost">
					<option value="noChoice" selected>--Choose One--</option>
					<option value="${listItemsToPost}"> ${listItemsToPost}</option>
	</c:forEach>
</select>  
			
			
	
	<%
				}
			%>
	
	
	 
</li>

</ul>		 --%>


		<table border="1">

			<tr>
				<th>&times;</th>
				<th>Available Quizemons</th>
			</tr>

			 <%
				for (UserQuizemon li : listItemsToPost) {
					System.out.println("th user name is:::");
					System.out.println(li.getUser());
					System.out.println("Quizemon is:::::");
					System.out.println(li.getQuizemon());
			%>

			<tr>
				<td><input type="radio" name="quizemon"
					value="<%=li.getQuizemon()%>"></td>
				<td><%=li.getQuizemon()%></td>
			</tr>

			<%
				}
			%>

		</table>

	</form>
		

<%@ include file="/WEB-INF/footer.jspf"%>
</body>
</html>