<%@page import="java.util.List"%>
<%@page import="java.util.Collections"%>
<%@page import="com.rossbille.seng4400.assignment2.beans.Event"%>
<%@page import="com.rossbille.seng4400.assignment2.beans.Records"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
Records records = (Records) getServletContext().getAttribute("records");
List<Event> events = records.getEvents();
%>
<!DOCTYPE html>

<html>
  <head>
   	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   	<title>Admin Console - Index</title>
  </head>
  <body>
    <h1>Welcome to the Admin Console</h1>
    <div>
    	<h2>Recent events:</h2>
   		<table border="1">
   			<tr>
   				<th>number</th><th>Time</th><th>Success</th>
 			</tr>
   		
			<% 
			Collections.sort(events);
			int count = 0;
			while(count<50 && count<events.size())
			{
				Event e = events.get(count);
			%>
	    	<tr>
	    		<td><%=count+1 %><td><%=e.getDate() %></td><td><%=e.isSuccess() %></td>
	    	</tr>
			<%
			System.out.println(e.isSuccess());
				count++;
			}
			%>
    	</table>
    	<a href="index.jsp">Refresh</a>
    </div>
  </body>
</html> 
