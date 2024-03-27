<%@page import="com.jsp.foodapp.entities.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% Product p=(Product)request.getAttribute("productdata"); %>
<form action="updatedata" method="post">
	enter id<input type="number" name="id" value=<%=p.getId()%> readonly="true"><br>
	enter name<input type="text" name="name" value=<%=p.getName()%> ><br>
	enter type<input type="text" name="type" value=<%=p.getType()%> ><br>
	enter cost<input type="number" name="cost" value=<%=p.getCost()%> ><br>
	<input type="submit">
</form>
</body>
</html>