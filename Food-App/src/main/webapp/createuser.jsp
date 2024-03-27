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
<form:form action="saveuser" modelAttribute="user">
	enter name<form:input path="name"/>
	enter mobile<form:input path="mobile"/>
	enter email<form:input path="email"/>
	enter password<form:input  type="password" path="password"/>
	<input type="submit">
	
</form:form>

</body>
</html>