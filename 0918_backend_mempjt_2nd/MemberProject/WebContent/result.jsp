<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% String result =  request.getParameter("res"); %>
	<h1><%= result %></h1>
	<a href="index.html">홈으로</a>
</body>
</html>