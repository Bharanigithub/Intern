<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to Method</h1>
	<h1><%=request.getAttribute("hello") %></h1>
	<h1><%=request.getAttribute("emp") %></h1>
</body>
</html>