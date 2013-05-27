<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Logged in</title>
</head>
<body>
	<div>
		Hi, welcome to the online store!<br />
		<%=session.getAttribute("lastResult")%>
		<form
			action="Pay" method="POST" id="form">
			<input type="radio" id="paypal" name="type" value="paypal"
				checked="checked" /> <label for="paypal">PayPal</label> <input
				type="radio" id="card" name="type" value="card" /> <label for="card">Credit
				Card</label><br /> <input id="id" name="id" placeholder="id" /><br /> <input
				type="submit" id="submit" />
		</form>
	</div>
</body>
</html>