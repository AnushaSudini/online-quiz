 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import= "java.util.List,edu.memphis.quizemon.model.Trade"%>
    <%@ page import= "java.util.List,edu.memphis.quizemon.model.TradeInfo"%>
  <%
	List<TradeInfo> tradeinformation = (List<TradeInfo>) request.getAttribute("tradeInformation");
%> 
<%-- <%
		TradeInfo tr = (TradeInfo) request.getAttribute("quizemon");
%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Offers</title>
</head>
<body>
	<h1>Trades List</h1>
	<table border="2">
	<tr>
		
	 <th> Trade Id </th> 
		<th> Quizemons Offered </th>
	</tr>
	  <%
			for (TradeInfo tri : tradeinformation) {
		%>  
	
	<tr>
			<%-- <td><%=tr.getRemoteUser() %></td>  --%>
			 <td><%=tri.getID() %></td> 
			 <td><%=tri.getQuizemon() %></td> 
</tr>
	
  <%
			}
		%>  

	</table>
	
<br>

	<%@ include file="/WEB-INF/footer.jspf"%>
</body>
</html>  