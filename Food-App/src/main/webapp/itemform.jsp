<%@page import="com.jsp.foodapp.entities.Item"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% Item i=(Item)request.getAttribute("itemsobj"); %>
<form:form action="additemtofoodorder" modelAttribute="itemsobj">
	enter name<form:input path="name"  value="<%=i.getName()%>" readonly="true"/>
	enter type<form:input path="type"  value="<%=i.getType()%>" readonly="true"/>
	enter cost<form:input path="cost"  value="<%=i.getCost()%>" readonly="true"/>
	quantity<form:input path="quantity"/>
	<input type="submit">

</form:form>

</body>
</html>