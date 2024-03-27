<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="saveadmin"  modelAttribute="admin">

enter name<form:input path="name"/>
enter email<form:input path="email"/>
enter password<form:input type="password" path="password"/>

<input type="submit">

</form:form>

</body>
</html>