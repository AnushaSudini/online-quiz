<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List,edu.memphis.quizemon.model.TradeInfo"%>
    <%
	List<TradeInfo> tradeInfoList = (List<TradeInfo>)request.getAttribute("tradeInfoList");
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<h1>View-Trade Form</h1>
<form action="<%=application.getContextPath()%>/ProposeTradeServlet.do"
		method="post">

		<p>
			<input type="submit" value="Propose Selected" name="proposeTrade">
		</p>

		<table border="1">

			<tr>
				<th>&times;</th>
				<th>Trade Id</th>
				<th>Quizemon Name</th>
			</tr>

			<%
				for (TradeInfo tr : tradeInfoList) {
					System.out.println("PROPOSE TRADE SERVLET"+tr.getID());
					System.out.println("PROPOSE TRADE SERVLET"+tr.getQuizemon());
			%>
			<tr>
			
			<td><input type="checkbox" name="id"
					value="<%=tr.getID()%>"></td>
				<td><%=tr.getID()%></td> 
				<td><%=tr.getQuizemon()%></td>
			</tr>

			<%
				}
			%>

		</table>

	</form>

	<br>

	<%@ include file="/WEB-INF/footer.jspf"%>
</body>
</html> 