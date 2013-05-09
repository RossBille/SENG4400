<%@page import="java.util.List"%>
<%@page import="java.util.Collections"%>
<%@page import="com.rossbille.seng4400.assignment2.beans.Event"%>
<%@page import="com.rossbille.seng4400.assignment2.beans.Records"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
//fetch records bean from application context
Records records = (Records) getServletContext().getAttribute("records");
//etract the list of events out of the bean
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
			//sort the list
			//due to backwards Event.compareTo(), these will be sorted in reverse order
			//by their timestamps
			Collections.sort(events);
			int count = 0;
			//print out the top 50 
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
